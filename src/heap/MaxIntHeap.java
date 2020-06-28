package heap;

import java.util.Arrays;

public class MaxIntHeap {
  private int capacity = 20;
  private int size = 0;
  int[] items;

  MaxIntHeap(int capacity) {
    this.capacity = capacity;
    this.items = new int[capacity];
//    Arrays.fill(this.items, -1);
  }

  private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private int leftChild(int index) {
    return items[getLeftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[getRightChildIndex(index)];
  }

  private int parent(int index) {
    return items[getParentIndex(index)];
  }

  public void printHeap() {
    System.out.println();
    for (int i = 0; i < size; i++) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }

  private void swap(int indexOne, int indexTwo) {
    int temp = items[indexOne];
    items[indexOne] = items[indexTwo];
    items[indexTwo] = temp;
  }

  public int getCapacity() {
    return this.capacity;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      items = Arrays.copyOf(items, capacity * 2);
      capacity *= 2;
    }
  }

  /**
   *
   * @return the minimum Element from the Heap
   */
  public int peek() {
    if (size == 0) throw new IllegalStateException("Heap is Empty!!");
    return items[0];
  }

  public int poll() {
    if (size == 0) throw new IllegalStateException();
    // Save the first item in a variable
    int item = items[0];

    // Swap the first item with the last Element
    items[0] = items[size - 1];

    // Mark place as empty
//    items[size - 1] = -1;
    size--;
    heapifyDown();
    return item;
  }

  public void add(int item) {
    ensureCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }

  public void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && parent(index) < items[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  public void heapifyDown() {
    int index = 0;

    while (hasLeftChild(index)) {
      // Assume left child is smaller
      int largerIndex = getLeftChildIndex(index);
      // Right child Index is smaller
      if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
        largerIndex = getRightChildIndex(index);
      }

      // Everything in order parent Index is greater the left and right node
      if (items[index] > items[largerIndex]) {
        break;
      } else {
        swap(index, largerIndex);
      }
    }
  }
}
