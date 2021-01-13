package graph;

import java.util.LinkedList;

public class GraphDriver {

    public static void main(String[] args) {
            int V = 4;
    	    Graph g = new Graph(V);

            g.addEdge(0, 3);
            g.addEdge(1, 0);
//            g.addEdge(3, 3);

            g.addEdge(2, 0);

            boolean edgeExist = g.isCyclic();
            System.out.println("Edge exist: " + edgeExist);
    }

}
