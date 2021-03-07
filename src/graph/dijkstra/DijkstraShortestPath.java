package graph.dijkstra;

import java.util.HashMap;
import java.util.Map;

import graph.Edge;
import graph.Graph;
import graph.Node;
import graph.Vertex;
import heap.BinaryMinHeap;



public class DijkstraShortestPath {

    public Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> gh, Vertex<Integer> sourceVertex) {
        BinaryMinHeap<Vertex<Integer>> binaryMinHeap = new BinaryMinHeap<>();
        Map<Vertex<Integer>, Integer> sourceMinDistanceMap = new HashMap<>();
        Map<Vertex<Integer>, Vertex<Integer>> shortestPathMap = new HashMap<>();

        for(Vertex<Integer> vertex : gh.getAllVertex()) {
            binaryMinHeap.add(Integer.MAX_VALUE, vertex);
        }

        // Decrease the source vertex to 0
        binaryMinHeap.decrease(sourceVertex, 0);
        shortestPathMap.put(sourceVertex, null);
        sourceMinDistanceMap.put(sourceVertex, 0);

        while(!binaryMinHeap.isEmpty()) {
            Node<Vertex<Integer>> currentNode = binaryMinHeap.pollNode();
            Vertex<Integer> currentVertex = currentNode.getKey();
            int weightFromSource = sourceMinDistanceMap.get(currentVertex);

            for(Edge<Integer> edge: currentVertex.getEdges()) {
                Vertex<Integer> adjVertex = edge.getVertex2();
                int distance = edge.getWeight() + weightFromSource;

                if(binaryMinHeap.containsKey(adjVertex) && distance < binaryMinHeap.getKeyWeight(adjVertex)) {
                    binaryMinHeap.decrease(adjVertex, distance);
                    sourceMinDistanceMap.put(adjVertex, distance);
                    shortestPathMap.put(adjVertex, currentVertex);
                }
            }
        }

        return  sourceMinDistanceMap;
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
