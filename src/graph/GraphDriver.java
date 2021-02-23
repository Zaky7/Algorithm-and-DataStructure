package graph;

public class GraphDriver {

    public static void main(String[] args) {
            int V = 4;
    	    Graph g = new Graph(true);

    	    Vertex A = new Vertex(1, "A");
            Vertex B = new Vertex(2, "B");
    	    Vertex C = new Vertex(3, "C");
    	    Vertex D = new Vertex(4, "D");


            g.addEdge(A,C);
            g.addEdge(B, C);
            g.addEdge(B, D);
            g.addEdge(C, D);


            System.out.println(g.toString());

    }

}
