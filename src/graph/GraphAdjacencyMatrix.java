package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjacencyMatrix {
    private final int V;
    private final int[][] adjMatrix;

    GraphAdjacencyMatrix(int V) {
        this.V = V;
        this.adjMatrix = new int[this.V][this.V];
    }

    public void addEdge(int src, int des) {
        this.adjMatrix[src][des] = 1;
    }

    public void printGraph() {
        System.out.println();
        for (int i = 0; i < this.V; i++) {
            for (int j = 0; j < this.V; j++) {
                System.out.print(this.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void BFS() {
        boolean[] visited = new boolean[this.V];

        for (int i = 0; i < this.V; i++) {
            if(!visited[i]) {
                BFSUtil(i, visited);
            }
        }
    }

    private void BFSUtil(int source, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int ele = queue.poll();
            System.out.println(ele);

            for(int j=0; j<this.V; j++) {
                if(this.adjMatrix[ele][j] == 1) {
                    if(!visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[this.V];
        for (int i = 0; i < this.V; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited);
                visited[i] = true;
            }
        }
    }

    private void DFSUtil(int src, boolean[] visited) {

        System.out.println(src);

        for (int j = 0; j < this.V; j++) {
            boolean edgeExist = this.adjMatrix[src][j] == 1;
            if(edgeExist && (!visited[j])) {
                DFSUtil(j, visited);
                visited[j] = true;
            }
        }
    }
}
