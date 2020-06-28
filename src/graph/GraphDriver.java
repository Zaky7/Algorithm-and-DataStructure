package graph;

public class GraphDriver {

    public static void main(String[] args) {
            int V = 4;
    	    Graph g = new Graph(V);

            // 1-> 3->4
            g.addEdge(0, 2);
            g.addEdge(0, 3);

            // 4->3
            g.addEdge(3, 2);

            // 2->3->4
            g.addEdge(1, 2);
            g.addEdge(1, 3);
            
            
            
    }

}
