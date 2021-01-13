package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int V;
    private final LinkedList<Integer>[] adjacencyList;

    Graph(int v) {
        this.V = v;
        this.adjacencyList = new LinkedList[this.V];

        for(int i=0; i<this.V; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int des) {
        this.adjacencyList[src].add(des);
    }

    public void BFS() {
        boolean[] visited = new boolean[this.V];
        System.out.println("BFS of Graph is: ");

        for (int i = 0; i < this.V; i++) {
            if(!visited[i]) {
                visited[i] = true;
                BFSUtil(i, visited);
            }
        }
    }

    private void BFSUtil(int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()) {
            int ele = queue.poll();
            System.out.print(ele + " ");

            Iterator<Integer> itr = this.adjacencyList[ele].listIterator();

            while(itr.hasNext()) {
                int n = itr.next();
                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[this.V];
        System.out.println("DFS of Graph is: ");


        for (int i = 0; i < this.V; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFSUtil(i, visited);
            }
        }
    }

    private void DFSUtil(int src, boolean[] visited) {
        System.out.print(src + " ");

        Iterator<Integer> itr = this.adjacencyList[src].listIterator();
        while(itr.hasNext()) {
            int n = itr.next();
            if(!visited[n]) {
                visited[n] = true;
                DFSUtil(n, visited);
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < this.V; i++) {
            System.out.println(i + "--> " + this.adjacencyList[i].toString());
        }
    }

    public boolean isCyclic() {
        boolean[] visited  = new boolean[this.V];
        boolean[] recStack = new boolean[this.V];

        for (int i = 0; i < this.V; i++) {
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int src, boolean[] visited, boolean[] recStack) {
        System.out.print(src + " ");

        if(!visited[src]) {
            visited[src] = true;
            recStack[src] = true;

            Iterator<Integer> itr = this.adjacencyList[src].listIterator();
            while(itr.hasNext()) {
                int n = itr.next();
                if(!visited[n] && isCyclicUtil(n, visited, recStack)) {
                    return true;
                } else if(recStack[n]) {
                    return true;
                }
            }
        }

        recStack[src] = false;
        return false;
    }

}
