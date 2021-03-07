package heap;

import graph.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {

  private List<Node> items;
  private Map<T, Integer> nodePositionMap;

  public BinaryMinHeap() {
    this.items = new ArrayList<>();
    this.nodePositionMap = new HashMap<>();
  }

  private int leftChildIndex(int index) {
    return 2 * index + 1;
  }

  private int rightChildIndex(int index) {
    return 2 * index + 2;
  }

  private int parentIndex(int index) {
    return (index - 1) / 2;
  }

  private boolean hasLeft(int index) {
    return leftChildIndex(index) < items.size();
  }

  private boolean hasRight(int index) {
    return rightChildIndex(index) < items.size();
  }

  private boolean hasParent(int index) {
    return parentIndex(index) >= 0;
  }

  private Node leftChild(int index) {
    return items.get(leftChildIndex(index));
  }

  private Node rightChild(int index) {
    return items.get(rightChildIndex(index));
  }

  private Node parent(int index) {
    return items.get(parentIndex(index));
  }

  private void swapNodes(int index1, int index2) {
    Node<T> node1 = this.items.get(index1);
    Node<T> node2 = this.items.get(index2);

    Node temp = node1;

    // update nodes in the heap
    this.items.set(index1, node2);
    this.items.set(index2, temp);

    // update nodes in the map
    nodePositionMap.put(node1.getKey(), index2);
    nodePositionMap.put(node2.getKey(), index1);
  }

  private void heapifyUp(int index) {
    while (
      hasParent(index) &&
      parent(index).getWeight() > this.items.get(index).getWeight()
    ) {
      int pIndex = parentIndex(index);
      swapNodes(index, pIndex);
      index = pIndex;
    }
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeft(index)) {
      int smallerChildIndex = leftChildIndex(index);

      if (
        hasRight(index) &&
        rightChild(index).getWeight() < items.get(smallerChildIndex).getWeight()
      ) {
        smallerChildIndex = rightChildIndex(index);
      }

      if (
        items.get(index).getWeight() < items.get(smallerChildIndex).getWeight()
      ) {
        break;
      } else {
        swapNodes(index, smallerChildIndex);
        index = smallerChildIndex;
      }
    }
  }

  public Node peek() {
    return items.get(0);
  }

  public T poll() {
    Node<T> deletedElement = pollNode();
    return deletedElement.getKey();
  }

  public Node<T> pollNode() {
    int first = 0;
    Node<T> deletedElement = items.get(first);

    // Swap the first element with last
    swapNodes(first, this.items.size() - 1);

    // remove the last element from heap and map
    items.remove(this.items.size() - 1);
    nodePositionMap.remove(deletedElement.getKey());

    // Now heapify Down to balance again
    heapifyDown();

    return deletedElement;
  }

  public void add(int weight, T key) {
    Node<T> node = new Node(weight, key);
    items.add(node);
    int index = this.items.size() - 1;
    this.nodePositionMap.put(node.getKey(), index);
    heapifyUp(index);
  }

  public boolean containsKey(T key) {
    return nodePositionMap.containsKey(key);
  }

  public void decrease(T key, int newVal) {
    int pos = nodePositionMap.get(key);
    Node oldNode = items.get(pos);
    // Update key value in Min Heap
    oldNode.update(newVal);
    heapifyUp(pos);
  }

  public int getKeyWeight(T key) {
    int pos = nodePositionMap.get(key);
    return items.get(pos).getWeight();
  }

  public void printBinaryHeap() {
    System.out.print("Binary heap: ");
    for (int i = 0; i < items.size(); i++) {
      System.out.print(items.get(i) + " ");
    }
    System.out.println(nodePositionMap.toString());
    System.out.println();
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }
}
