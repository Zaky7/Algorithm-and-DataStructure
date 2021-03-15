package graph.toplogoicalSort;

import graph.helper.Graph;
import graph.helper.Vertex;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TopologicalSort<T> {

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

  public static void main(String[] args) {
    //    Graph graph = new Graph(true);
    //
    //    /***
    //     *       A   B
    //     *       \ / \
    //     *       C    \
    //     *     /       \
    //     *    D        E
    //     *     \      /
    //     *        F
    //     *        |
    //     *        G
    //     */
    //    Vertex A = new Vertex(1, "A");
    //    Vertex B = new Vertex(2, "B");
    //    Vertex C = new Vertex(3, "C");
    //    Vertex D = new Vertex(4, "D");
    //    Vertex E = new Vertex(5, "E");
    //    Vertex F = new Vertex(6, "F");
    //    Vertex G = new Vertex(7, "G");
    //
    //    graph.addEdge(A, C);
    //    graph.addEdge(B, C);
    //    graph.addEdge(C, D);
    //    graph.addEdge(B, E);
    //    graph.addEdge(D, F);
    //    graph.addEdge(E, F);
    //    graph.addEdge(F, G);
    //
    //    graph.addEdge(A, B);
    //    graph.addEdge(A, D);
    //    graph.addEdge(B, C);
    //
    //    System.out.println(graph.toString());
    //    GraphTraversal<Integer> gt = new GraphTraversal();
    //    gt.BFS(graph);
    //    gt.DFS(graph);
    //
    //    TopoLogicalSort<Integer> ts = new TopoLogicalSort<Integer>();
    //    Deque<Vertex<Integer>> topSort = ts.topoLogicalSort(graph);
    //    System.out.println(topSort.toString());

  }
}
