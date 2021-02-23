package heap;

import java.util.Arrays;

public class MaxIntHeap2 {

  int capacity = 0;
  int items[];
  int heapSize = 0;
  private static final int DEFAULT_CAPACITY = 11;

  MaxIntHeap2() {
    items = new int[DEFAULT_CAPACITY];
    this.capacity = DEFAULT_CAPACITY;
  }

  MaxIntHeap2(int size) {
    items = new int[size];
    this.capacity = size;
  }

  private int getLeftChildIndex(int index) {
    return (2 * index) + 1;
  }

  private int getRightChildIndex(int index) {
    return (2 * index) + 2;
  }

  private int getParentIndex(int index) {
    return (index - 1) >> 1;
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

  private boolean hasLeft(int index) {
    return getLeftChildIndex(index) < heapSize;
  }

  private boolean hasRight(int index) {
    return getRightChildIndex(index) < heapSize;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  public void swap(int index1, int index2) {
    int temp = items[index1];
    items[index1] = items[index2];
    items[index2] = temp;
  }

  public int getCapacity() {
    return this.capacity;
  }

  private void ensureCapacity() {
    if (heapSize == capacity) {
      items = Arrays.copyOf(items, 2 * heapSize);
      capacity = capacity << 1;
    }
  }

  public void add(int ele) {
    // Ensuring Capacity
    ensureCapacity();

    // Append the element at heap's end
    items[heapSize++] = ele;

    // Heapify up from that index
    heapifyUp();
  }

  private void heapifyUp() {
    int index = heapSize - 1;

    while (hasParent(index) && parent(index) < items[index]) {
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  private void heapifyDown() {
    int index = 0;

    while (hasLeft(index)) {
      int largestIndex = getLeftChildIndex(index);

      if (hasRight(index) && rightChild(index) > leftChild(index)) {
        largestIndex = getRightChildIndex(index);
      }

      // Since current index is greater everything is balanced
      if (items[index] > items[largestIndex]) {
        break;
      } else {
        swap(largestIndex, index);
      }
    }
  }

  public void printHeap() {
    System.out.println();
    for (int i = 0; i < heapSize; i++) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }

  public int poll() {
    if (heapSize < 1) {
      throw new IllegalStateException("Heap is Empty!!");
    }

    int first = 0;

    // save the deleted Element in variable
    int deletedItem = items[first];

    // swap first element with the last element
    swap(first, heapSize - 1);

    // Decrease heapSize and heapify down from first index until heap balances
    heapSize--;
    heapifyDown();
    return deletedItem;
  }
}
