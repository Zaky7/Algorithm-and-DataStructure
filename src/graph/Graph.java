package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];


    Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int v, boolean[] visited) {
        // Created an Array of Boolean
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() > 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    void BFS(int v) {
        // Created an Array of Boolean
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() > 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> itr = adj[v].listIterator();

        while(itr.hasNext()) {
            int n = itr.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    
    public int getNotConnectedNodes() {
        boolean[] visited = new boolean[V];
        int notConnectedNodes = V;

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                visited[i] = true;
                notConnectedNodes--;
                BFS(i, visited);
                System.out.println();
            }
        }
        return notConnectedNodes;
    }
}
