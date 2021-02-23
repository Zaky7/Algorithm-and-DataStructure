package graph;

public class GraphDriver {

    public static void main(String[] args) {
            int V = 4;
    	    Graph graph = new Graph(true);


        /***
         *       A
         *     /  \
         *    B   D
         *   /
         *  C
         *
         */
        Vertex A = new Vertex(1, "A");
            Vertex B = new Vertex(2, "B");
    	    Vertex C = new Vertex(3, "C");
    	    Vertex D = new Vertex(4, "D");


            graph.addEdge(A,B);
            graph.addEdge(A, D);
            graph.addEdge(B, C);

            System.out.println(graph.toString());
            GraphTraversal gt = new GraphTraversal();

            gt.BFS(graph);
            gt.DFS(graph);

    }

}
