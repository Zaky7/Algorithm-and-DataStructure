package graph.bellmanford;

import graph.helper.Edge;
import graph.helper.Graph;
import graph.helper.Vertex;
import java.util.HashMap;
import java.util.Map;

public class BellmanFordShortestPath {

  //some random big number is treated as infinity. I m not taking INTEGER_MAX as infinity because
  //doing any addition on that causes integer overflow
  private static int INFINITY = 10000000;

  class NegativeWeightCycleException extends RuntimeException {}

  public Map<Vertex<Integer>, Integer> shortestPath(
    Graph<Integer> graph,
    Vertex<Integer> source
  ) {
    Map<Vertex<Integer>, Integer> distance = new HashMap<>();
    Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

    // Mark distance maximum from all vertex
    for (Vertex<Integer> v : graph.getAllVertex()) {
      distance.put(v, INFINITY);
    }

    int V = graph.getAllVertex().size();
    distance.put(source, 0);
    parent.put(source, null);

    // Perform Relaxation V - 1 times
    for (int i = 0; i < V - 1; i++) {
      //            System.out.println("Iteration: " + i);

      for (Edge<Integer> edge : graph.getAllEdges()) {
        Vertex<Integer> u = edge.getVertex1();
        Vertex<Integer> v = edge.getVertex2();

        //                System.out.println("U: " + u.toString() + " V: " + v.toString() + " Edge: " + edge.toString() + " map: " + distance.toString());

        // Relaxing and Edge
        if (distance.get(u) + edge.getWeight() < distance.get(v)) {
          distance.put(v, distance.get(u) + edge.getWeight());
          parent.put(v, u);
        }
      }
    }

    //relax all edges again. If we still get lesser distance it means
    //there is negative weight cycle in the graph. Throw exception in that
    //case
    for (Edge<Integer> edge : graph.getAllEdges()) {
      Vertex<Integer> u = edge.getVertex1();
      Vertex<Integer> v = edge.getVertex2();
      if (distance.get(u) + edge.getWeight() < distance.get(v)) {
        throw new NegativeWeightCycleException();
      }
    }
    return distance;
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<>(false);

    Vertex A = new Vertex(1, "A");
    Vertex B = new Vertex(2, "B");
    Vertex C = new Vertex(3, "C");
    Vertex D = new Vertex(4, "D");
    Vertex E = new Vertex(5, "E");
    Vertex F = new Vertex(6, "F");

    /**
     *
     *       B ----2----- C
     *      /             |
     *     5              3
     *    /               |
     *   A---------9----- D
     *   \                |
     *    2               2
     *     \              |
     *      E -----3----- F
     **/

    graph.addEdge(A, B, 5);
    graph.addEdge(A, E, 2);
    graph.addEdge(A, D, 9);
    graph.addEdge(B, C, 2);
    graph.addEdge(E, F, 3);
    graph.addEdge(C, D, 3);
    graph.addEdge(D, F, 2);

    //        System.out.println(graph.toString());

    BellmanFordShortestPath bfsp = new BellmanFordShortestPath();
    System.out.println(bfsp.shortestPath(graph, A));
  }
}
