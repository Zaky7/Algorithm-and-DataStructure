package graph;

import java.util.*;

public class TopoLogicalSort<T> {

  public Deque<Vertex<T>> topoLogicalSort(Graph<T> graph) {
    Deque<Vertex<T>> stack = new ArrayDeque<>();
    Set<Long> visited = new HashSet<>();

    System.out.println("\nTopoLogical Sort of graph:");

    for (Vertex<T> vertex : graph.getAllVertex()) {
      if (!visited.contains(vertex.getId())) {
        visited.add(vertex.getId());
        topoLogicalSortUtil(vertex, visited, stack);
      }
    }

    return stack;
  }

  private void topoLogicalSortUtil(
    Vertex<T> vertex,
    Set<Long> visited,
    Deque<Vertex<T>> stack
  ) {
    for (Vertex<T> childVertex : vertex.getAdjacentVertexes()) {
      if (!visited.contains(childVertex.getId())) {
        visited.add(childVertex.getId());
        topoLogicalSortUtil(childVertex, visited, stack);
      }
    }

    stack.offerFirst(vertex);
  }
}
