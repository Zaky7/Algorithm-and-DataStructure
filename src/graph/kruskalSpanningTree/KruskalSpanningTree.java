package graph.kruskalSpanningTree;

import graph.disjointSet.DisjointSet;
import graph.helper.Edge;
import graph.helper.Graph;
import graph.helper.Vertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalSpanningTree {

  public class EdgeComparator implements Comparator<Edge<Integer>> {

    @Override
    public int compare(Edge<Integer> o1, Edge<Integer> o2) {
      return o1.getWeight() - o2.getWeight();
    }
  }

  public List<Edge> kruskalMST(Graph<Integer> g) {
    List<Edge> resultEdge = new ArrayList<>();
    DisjointSet ds = new DisjointSet();
    EdgeComparator edgeComparator = new EdgeComparator();

    // Add all vertices to the disjoint sets
    for (Vertex<Integer> v : g.getAllVertex()) {
      ds.makeSet(v.getId());
    }

    // Sort all the edges in asc order
    Collections.sort(g.getAllEdges(), edgeComparator);

    System.out.println("Minimum Spanning Tree: ");
    for (Edge<Integer> edge : g.getAllEdges()) {
      long root1 = ds.findSet(edge.getVertex1().getId());
      long root2 = ds.findSet(edge.getVertex2().getId());

      if (root1 == root2) {
        continue;
      } else {
        resultEdge.add(edge);
        ds.union(root1, root2);
      }
    }

    return resultEdge;
  }

  public static void main(String[] args) {
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
