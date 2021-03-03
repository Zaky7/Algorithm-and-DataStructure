package graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

  private Map<Long, Node> map = new HashMap<>();

  class Node {

    long data;
    Node parent;
    int rank;
  }

  /**
   * Create an empty Set
   * @param data
   */
  public void makeSet(long data) {
    Node node = new Node();
    node.data = data;
    node.parent = node;
    node.rank = 0;
    map.put(data, node);
  }

  /**
   * Join the two sets into one
   * @param data1
   * @param data2
   * @return
   */
  public boolean union(long data1, long data2) {
    Node node1 = map.get(data1);
    Node node2 = map.get(data2);

    Node parent1 = findSet(node1);
    Node parent2 = findSet(node2);

    if (node1.data == node2.data) {
      return false;
    }

    if (parent1.rank >= parent2.rank) {
      /*
       * If two set of same rank are joined then
       * resultant rank is incremented by one
       * */
      parent1.rank =
        parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
      parent2.parent = parent1;
    } else {
      /*
       * No change in rank is made
       * */
      parent1.parent = parent2;
    }

    return true;
  }

  /**
   * @param data
   * @return the parent node
   */
  public long findSet(long data) {
    return findSet(map.get(data)).data;
  }

  /**
   * Find the parent node recursively
   * @param node
   * @return
   */
  private Node findSet(Node node) {
    Node parent = node.parent;

    if (parent == node) {
      return parent;
    }

    // Perform the path compression
    node.parent = findSet(parent);
    return node.parent;
  }
}
