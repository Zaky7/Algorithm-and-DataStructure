package graph;

import java.util.*;

public class Graph<T> {
    private final Map<Long, Vertex<T>> allVertexMap;
    private final List<Edge<T>> allEdges;
    private final boolean isDirected;

    Graph(boolean isDirected) {
        this.isDirected = isDirected;
        allEdges = new ArrayList<>();
        this.allVertexMap = new HashMap<>();
    }

    public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
        addEdge(vertex1, vertex2, 0);
    }

    public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
        allVertexMap.put(vertex1.getId(), vertex1);
        allVertexMap.put(vertex2.getId(), vertex2);
        Edge<T> edge = new Edge<>(vertex1, vertex2,weight, isDirected);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected) {
            vertex2.addAdjacentVertex(edge, vertex1);
        }
    }

    public void addVertex(Vertex<T> vertex) {
        if(allVertexMap.containsKey(vertex.getId())) {
            return;
        }
        allVertexMap.put(vertex.getId(), vertex);
        allEdges.addAll(vertex.getEdges());
    }

    public Vertex<T> addSingleVertex(long id) {
        Vertex<T> v = allVertexMap.getOrDefault(id, new Vertex<>(id));
        allVertexMap.put(id, v);
        return v;
    }

    public Vertex<T> getVertex(long id) {
        return allVertexMap.get(id);
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex() {
        return allVertexMap.values();
    }

    public void setDataForVertex(long id, T data) {
        if(allVertexMap.containsKey(id)) {
            allVertexMap.get(id).setData(data);
        }
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Long, Vertex<T>> vertexEntry : allVertexMap.entrySet()) {
            Vertex vertex = vertexEntry.getValue();
            builder.append(vertex.toString()).append(" --> ").append(vertex.getAdjacentVertexes().toString()).append("\n");
        }
        return builder.toString();
    }
}

class Vertex<T> {
    long id;
    private T data;
    private final List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }

    Vertex(long id, T data) {
        this.id = id;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
        edges.add(e);
        adjacentVertex.add(v);
    }

    public String toString() {
        return "(" + String.valueOf(id) + ", " + data.toString() + ")";
    }

    public List<Vertex<T>> getAdjacentVertexes() {
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public int getDegree() {
        return edges.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<T> other = (Vertex<T>) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
}

class Edge<T> {
    private boolean isDirected = false;
    private final Vertex<T> vertex1;
    private final Vertex<T> vertex2;
    private int weight;

    /**
     * for undirected and non-weighted graph
     * @param vertex1
     * @param vertex2
     */
    Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }


    /**
     * for undirected and weighted graph
     * @param vertex1
     * @param vertex2
     * @param weight
     */
    Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
      this.vertex1 = vertex1;
      this.vertex2 = vertex2;
      this.weight = weight;
    }


    /**
     * for directed and weighted Graph
     * @param vertex1
     * @param vertex2
     * @param weight
     * @param isDirected
     */
    Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
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
        return isDirected == other.isDirected && weight == other.weight && Objects.equals(vertex1, other.vertex1) && Objects.equals(vertex2, other.vertex2);
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
        return "Edge[" +
                "isDirected=" + isDirected +
                ", vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                ']';
    }
}