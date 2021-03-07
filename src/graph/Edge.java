package graph;

import java.util.Objects;

public class Edge<T> {

    private boolean isDirected = false;
    private final Vertex<T> vertex1;
    private final Vertex<T> vertex2;
    private int weight;

    /**
     * for undirected and non-weighted graph
     *
     * @param vertex1
     * @param vertex2
     */
    Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    /**
     * for undirected and weighted graph
     *
     * @param vertex1
     * @param vertex2
     * @param weight
     */
    Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
        this(vertex1, vertex2);
        this.weight = weight;
    }

    /**
     * for directed and weighted Graph
     *
     * @param vertex1
     * @param vertex2
     * @param weight
     * @param isDirected
     */
    Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
        this(vertex1, vertex2, weight);
        this.isDirected = isDirected;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> other = (Edge<?>) o;
        return (
                isDirected == other.isDirected &&
                        weight == other.weight &&
                        Objects.equals(vertex1, other.vertex1) &&
                        Objects.equals(vertex2, other.vertex2)
        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public String toString() {
        //    return (
        //      "Edge[" +
        //      "isDirected=" +
        //      isDirected +
        //      ", vertex1=" +
        //      vertex1 +
        //      ", vertex2=" +
        //      vertex2 +
        //      ", string=" + (vertex1 + "->" +vertex2) +
        //      ", weight=" +
        //      weight +
        //      ']'
        //    );

        return (
                "Edge[" + "" + (vertex1 + "->" + vertex2) + ", weight=" + weight + ']'
        );
    }
}
