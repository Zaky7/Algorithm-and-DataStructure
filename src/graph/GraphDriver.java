package graph;

import java.util.List;

public class GraphDriver {

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

    //    Graph graph = new Graph(false);
    //
    //    /**
    //     * A -->  D  -->  E
    //     * |   / |    / |
    //     * | /   |  /   |
    //     * B --> C -->  F
    //     */
    //    Vertex A = new Vertex(1, "A");
    //    Vertex B = new Vertex(2, "B");
    //    Vertex C = new Vertex(3, "C");
    //    Vertex D = new Vertex(4, "D");
    //    Vertex E = new Vertex(5, "E");
    //    Vertex F = new Vertex(6, "F");
    //
    //    graph.addEdge(A, D, 1);
    //    graph.addEdge(A, B, 3);
    //
    //    graph.addEdge(B, D, 3);
    //    graph.addEdge(B, C, 1);
    //
    //    graph.addEdge(C, D, 1);
    //    graph.addEdge(C, E, 5);
    //    graph.addEdge(C, F, 4);
    //
    //    graph.addEdge(D, E, 6);
    //
    //    graph.addEdge(E, F, 2);
    //
    //    System.out.println(graph.toString());
    //
    //    PrimMST primMST = new PrimMST();
    //    List<Edge<Integer>> spanningEdges = primMST.primMST(graph);
    //
    //    for (Edge<Integer> edge : spanningEdges) {
    //      System.out.println(edge.toString());
    //    }

    /**
     * A -->  D  -->  E
     * |   / |    / |
     * | /   |  /   |
     * B --> C -->  F
     */
    Vertex A = new Vertex(1, "A");
    Vertex B = new Vertex(2, "B");
    Vertex C = new Vertex(3, "C");
    Vertex D = new Vertex(4, "D");
    Vertex E = new Vertex(5, "E");
    Vertex F = new Vertex(6, "F");

    Graph<Integer> graph = new Graph<>(false);
    graph.addEdge(A, D, 1);
    graph.addEdge(A, B, 3);
    graph.addEdge(B, D, 3);
    graph.addEdge(B, C, 1);
    graph.addEdge(C, D, 1);
    graph.addEdge(C, E, 5);
    graph.addEdge(C, F, 4);
    graph.addEdge(D, E, 6);
    graph.addEdge(E, F, 2);

    KruskalSpanningTree ksp = new KruskalSpanningTree();
    for (Edge e : ksp.kruskalMST(graph)) {
      System.out.println(e);
    }
  }
}
