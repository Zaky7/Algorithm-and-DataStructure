package graph;

import java.util.Deque;

public class GraphDriver {

    public static void main(String[] args) {
    	    Graph graph = new Graph(true);


            /***
             *       A   B
             *       \ / \
             *       C    \
             *     /       \
             *    D        E
             *     \      /
             *        F
             *        |
             *        G
             */
            Vertex A = new Vertex(1, "A");
            Vertex B = new Vertex(2, "B");
    	    Vertex C = new Vertex(3, "C");
    	    Vertex D = new Vertex(4, "D");
    	    Vertex E = new Vertex(5, "E");
    	    Vertex F = new Vertex(6, "F");
    	    Vertex G = new Vertex(7, "G");


            graph.addEdge(A,C);
            graph.addEdge(B,C);
            graph.addEdge(C,D);
            graph.addEdge(B,E);
            graph.addEdge(D,F);
            graph.addEdge(E,F);
            graph.addEdge(F,G);

            graph.addEdge(A,B);
            graph.addEdge(A, D);
            graph.addEdge(B, C);



        System.out.println(graph.toString());
            GraphTraversal<Integer> gt = new GraphTraversal();
            gt.BFS(graph);
            gt.DFS(graph);

            TopoLogicalSort<Integer> ts = new TopoLogicalSort<Integer>();
            Deque<Vertex<Integer>> topSort = ts.topoLogicalSort(graph);
            System.out.println(topSort.toString());
    }

}
