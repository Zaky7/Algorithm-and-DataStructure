package graph;

import heap.BinaryMinHeap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimMST {

  public List<Edge<Integer>> primMST(Graph<Integer> graph) {
    BinaryMinHeap<Vertex<Integer>> binaryMinHeap = new BinaryMinHeap<>();
    Map<Vertex<Integer>, Edge<Integer>> edgeVertexMap = new HashMap<>();

    List<Edge<Integer>> result = new ArrayList<>();

    for (Vertex<Integer> vertex : graph.getAllVertex()) {
      binaryMinHeap.add(Integer.MAX_VALUE, vertex);
    }

    Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
    binaryMinHeap.decrease(startVertex, 0);

    binaryMinHeap.printBinaryHeap(); // to remove

    while (!binaryMinHeap.isEmpty()) {
      Vertex<Integer> vertex = binaryMinHeap.poll();

      // If particular vertex has entry add it to the result
      if (edgeVertexMap.containsKey(vertex)) {
        result.add(edgeVertexMap.get(vertex));
      }

      System.out.println(
        "Main vertex: " + vertex.toString() + " result: " + result.toString()
      );

      // For all adjacent edges add to binary Heap if weight is less than what already present
      for (Edge edge : vertex.getEdges()) {
        Vertex<Integer> adjVertex = edge.getVertex2();

        System.out.println(
          edge.toString() +
          " weight: " +
          (
            binaryMinHeap.containsKey(adjVertex)
              ? binaryMinHeap.getKeyWeight(adjVertex)
              : "null"
          ) +
          " edge weight: " +
          edge.getWeight()
        );

        if (
          binaryMinHeap.containsKey(adjVertex) &&
          binaryMinHeap.getKeyWeight(adjVertex) > edge.getWeight()
        ) {
          binaryMinHeap.decrease(adjVertex, edge.getWeight());
          edgeVertexMap.put(adjVertex, edge);
        }

        binaryMinHeap.printBinaryHeap();
      }
    }

    return result;
  }
}
