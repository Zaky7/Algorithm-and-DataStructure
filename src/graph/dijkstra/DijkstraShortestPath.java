package graph.dijkstra;

import graph.helper.Edge;
import graph.helper.Graph;
import graph.helper.Node;
import graph.helper.Vertex;
import heap.BinaryMinHeap;
import java.util.HashMap;
import java.util.Map;

public class DijkstraShortestPath {

  public Map<Vertex<Integer>, Integer> shortestPath(
    Graph<Integer> gh,
    Vertex<Integer> sourceVertex
  ) {
    // Heap + Map Data structure
    BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();

    Map<Vertex<Integer>, Integer> sourceMinDistanceMap = new HashMap<>();

    Map<Vertex<Integer>, Vertex<Integer>> parentMap = new HashMap<>();

    for (Vertex<Integer> vertex : gh.getAllVertex()) {
      minHeap.add(Integer.MAX_VALUE, vertex);
    }

    // Decrease the source vertex to 0
    minHeap.decrease(sourceVertex, 0);

    sourceMinDistanceMap.put(sourceVertex, 0);

    parentMap.put(sourceVertex, null);

    while (!minHeap.isEmpty()) {
      Node<Vertex<Integer>> currentNode = minHeap.pollNode();
      Vertex<Integer> currentVertex = currentNode.getKey();
      int weightFromSource = sourceMinDistanceMap.get(currentVertex);

      for (Edge<Integer> edge : currentVertex.getEdges()) {
        Vertex<Integer> adjVertex = edge.getVertex2();
        int distance = edge.getWeight() + weightFromSource;

        if (
          minHeap.containsKey(adjVertex) &&
          distance < minHeap.getKeyWeight(adjVertex)
        ) {
          minHeap.decrease(adjVertex, distance);
          sourceMinDistanceMap.put(adjVertex, distance);
          parentMap.put(adjVertex, currentVertex);
        }
      }
    }

    return sourceMinDistanceMap;
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

    System.out.println(graph.toString());

    DijkstraShortestPath dsp = new DijkstraShortestPath();
    System.out.println(dsp.shortestPath(graph, A));
  }
}
