package graph;

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
}
