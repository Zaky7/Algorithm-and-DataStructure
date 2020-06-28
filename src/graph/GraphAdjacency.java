package graph;

import java.util.LinkedList;

public class GraphAdjacency {
    private int vertices;
    private int edges;
    private int[][] adjacencyMatrix;


    GraphAdjacency(int v) {
        this.vertices = v;
        this.edges = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        for(int i=0; i<this.vertices; i++) {
            for(int j=0; j< this.edges; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    void addEdge(int v, int w) {
        if(v < vertices && w < edges) {
            adjacencyMatrix[v][w] = 1;
        }
        else {
            throw new UnsupportedOperationException("Vertice or Edge out of bound");
        }
    }

    void bfsUtil(int v, boolean[] visited) {
        // Created an Array of Boolean
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() > 0) {
            v = queue.poll();
            System.out.print(v + " ");

            for(int vertex=0; vertex<vertices; vertex++) {
                int edgeExist = adjacencyMatrix[v][vertex];
                if(edgeExist == 1 && (!visited[vertex])) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }


    void bfs(int v) {
        // Created an Array of Boolean
        boolean[] visited = new boolean[vertices];
        bfsUtil(v, visited);
    }


    void dfs(int v) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(v, visited);
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=0; i<vertices; i++) {
            int n = adjacencyMatrix[v][i];
            if(adjacencyMatrix[v][i] == 1 && (!visited[n])) {
                visited[i] = true;
                dfsUtil(n, visited);
            }
        }
    }

    public int getNotConnectedNodes() {
        boolean[] visited = new boolean[vertices];
        int notConnectedNodes = 0;

        for(int i=0; i<vertices; i++) {
            if(!visited[i]) {
                visited[i] = true;
                notConnectedNodes++;
                bfsUtil(i, visited);
                System.out.println();
            }
        }
        return notConnectedNodes;
    }
}
