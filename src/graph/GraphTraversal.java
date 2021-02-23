package graph;

import java.util.*;

public class GraphTraversal<T> {

    public void BFS(Graph<T> graph) {
        Set<Long> visited = new HashSet<>();
        System.out.println("\n BFS of given graph: ");
        for(Vertex<T> vertex : graph.getAllVertex()) {
            if(!visited.contains(vertex.getId())) {
                BSFUtil(vertex, visited);
            }
         }
    }

    private void BSFUtil(Vertex<T> vertex, Set<Long> visited) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(vertex);
        visited.add(vertex.getId());

        while(queue.size() != 0) {
            Vertex v = queue.poll();
            System.out.print(v.toString() + " --> ");

            List<Vertex<T>> adjVertices = v.getAdjacentVertexes();

            for (Vertex<T> vAdj: adjVertices) {
                if(!visited.contains(vAdj.getId())) {
                    queue.add(vAdj);
                    visited.add(vAdj.getId());
                }
            }
        }
    }

    public void DFS(Graph<T> graph) {
        Set<Long> visited = new HashSet<>();
        System.out.println("\n DFS of given graph: ");
        for(Vertex<T> vertex : graph.getAllVertex()) {
            if(!visited.contains(vertex.getId())) {
                visited.add(vertex.getId());
                DSFUtil(vertex, visited);
            }
        }
    }

    private void DSFUtil(Vertex<T> v, Set<Long> visited) {
        System.out.print(v.toString() + " --> ");
        List<Vertex<T>> adjVertices = v.getAdjacentVertexes();

        for (Vertex<T> vAdj: adjVertices) {
            if(!visited.contains(vAdj.getId())) {
                visited.add(vAdj.getId());
                DSFUtil(vAdj, visited);
            }
        }
    }
}
