package graph;

import java.util.*;

public class Graph<T> {

  private final Map<Long, Vertex<T>> allVertexMap;
  private final List<Edge<T>> allEdges;
  private final boolean isDirected;

  public Graph(boolean isDirected) {
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
    Edge<T> edge = new Edge<>(vertex1, vertex2, weight, isDirected);
    allEdges.add(edge);
    vertex1.addAdjacentVertex(edge, vertex2);
    if (!isDirected) {
      Edge<T> reverseEdge = new Edge<>(vertex2, vertex1, weight, isDirected);
      vertex2.addAdjacentVertex(reverseEdge, vertex1);
    }
  }

  public void addVertex(Vertex<T> vertex) {
    if (allVertexMap.containsKey(vertex.getId())) {
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
    if (allVertexMap.containsKey(id)) {
      allVertexMap.get(id).setData(data);
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Graph: ");
    for (Map.Entry<Long, Vertex<T>> vertexEntry : allVertexMap.entrySet()) {
      Vertex vertex = vertexEntry.getValue();
      builder
        .append(vertex.toString())
        .append(" --> ")
        .append(vertex.getAdjacentVertexes().toString())
        .append(" ")
        .append(vertex.getEdges())
        .append("\n");
    }
    return builder.toString();
  }
}

