package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CourseSchedule {

  class Graph {

    private int V;
    private LinkedList<Integer> adjacencyList[];
    private int WHITE = 0;
    private int GREY = 1;
    private int BLACK = 2;

    Graph(int V) {
      this.V = V;
      adjacencyList = new LinkedList[V];

      for (int i = 0; i < V; i++) {
        adjacencyList[i] = new LinkedList();
      }
    }

    void add(int v, int w) {
      adjacencyList[v].add(w);
    }

    boolean isCyclicUtil(int vertex, int[] color) {
      // Mark the current vertex as being processed
      color[vertex] = GREY;

      Iterator<Integer> itr = adjacencyList[vertex].listIterator();

      while (itr.hasNext()) {
        int n = itr.next();

        // If vertex already processed then there is cycle present
        if (color[n] == GREY) {
          return true;
        }

        // if current children contain cycle then also return true
        if (color[n] == WHITE && isCyclicUtil(n, color) == true) {
          return true;
        }
      }

      // Since no cycle is present mark node as black
      color[vertex] = BLACK;
      return false;
    }

    boolean isCyclic() {
      // Initialize color array as white
      int[] color = new int[V];

      for (int i = 0; i < V; i++) {
        if (color[i] == WHITE) {
          if (isCyclicUtil(i, color) == true) {
            return true;
          }
        }
      }
      return false;
    }

    void DFSUtil(int v, boolean[] visited, Stack<Integer> stack) {
      System.out.println("\nVertex: " + v + " stack: " + stack.toString());

      visited[v] = true;

      Iterator<Integer> itr = adjacencyList[v].listIterator();

      while (itr.hasNext()) {
        int n = itr.next();

        if (visited[n] == false) {
          DFSUtil(n, visited, stack);
        }
      }

      stack.push(v);
    }

    public int[] getTopologicalOrder() {
      boolean visited[] = new boolean[V];
      Stack<Integer> stack = new Stack<>();
      int[] topologicalOrder = new int[V];

      for (int i = 0; i < V; i++) {
        if (visited[i] == false) {
          DFSUtil(i, visited, stack);
        }
      }

      int index = 0;
      while (!stack.isEmpty()) {
        topologicalOrder[index] = stack.pop();
        index++;
      }

      return topologicalOrder;
    }
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Graph graph = new Graph(numCourses);
    int[] coursesOrder = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      int[] prerequisite = prerequisites[i];
      if (prerequisite.length == 2) {
        graph.add(prerequisite[1], prerequisite[0]);
      }
    }

    // If graph is cyclic return empty array
    if (graph.isCyclic()) {
      return new int[0];
    }

    coursesOrder = graph.getTopologicalOrder();
    return coursesOrder;
  }

  public static void main(String[] args) {
    int numCourses = 8;
    int[][] prerequisites = { { 2, 1 }, { 7, 2 }, { 0, 4 }, { 6, 5 } };

    //        int numCourses = 4;
    //        int[][] prerequisites = {
    //                {1,0},
    //                {2,0},
    //                {3,1},
    //                {3,2}
    //        };

    CourseSchedule cs = new CourseSchedule();
    int[] order = cs.findOrder(numCourses, prerequisites);

    System.out.println();
    for (int i = 0; i < order.length; i++) {
      System.out.print(order[i] + " ");
    }
    System.out.println();
  }
}
