package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinIntHeap2 {

  int[] items;
  int heapSize;
  int capacity;

  MinIntHeap2(int size) {
    this.items = new int[size];
    this.heapSize = 0;
    this.capacity = size;
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
    return leftChildIndex(index) < heapSize;
  }

  private boolean hasRight(int index) {
    return rightChildIndex(index) < heapSize;
  }

  private boolean hasParent(int index) {
    return parentIndex(index) >= 0;
  }

  private int leftChild(int index) {
    return items[leftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[rightChildIndex(index)];
  }

  private int parent(int index) {
    return items[parentIndex(index)];
  }

  public void printHeap() {
    System.out.println();
    for (int i = 0; i < heapSize; i++) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }

  public int getCapacity() {
    return capacity;
  }

  public int peek() {
    return items[0];
  }

  public void add(int ele) {
    ensureCapacity();
    this.items[heapSize++] = ele;
    heapifyUp();
  }

  public int poll() {
    if (heapSize <= 0) {
      throw new IllegalArgumentException("Heap is Empty!!");
    }

    int first = 0;
    int deletedElement = items[first];

    // Swap the first element with last
    swap(first, heapSize - 1);

    heapSize--;

    // Now heapify Down
    heapifyDown();

    return deletedElement;
  }

  private void swap(int index1, int index2) {
    int temp = this.items[index1];
    this.items[index1] = this.items[index2];
    this.items[index2] = temp;
  }

  private void ensureCapacity() {
    if (heapSize >= capacity) {
      items = Arrays.copyOf(items, 2 * capacity);
      this.capacity *= 2;
    }
  }

  private void heapifyUp() {
    int index = this.heapSize - 1;
    while (hasParent(index) && parent(index) > this.items[index]) {
      int pIndex = parentIndex(index);
      swap(index, pIndex);
      index = pIndex;
    }
  }

  private void heapifyDown() {
    int index = 0;

    while (hasLeft(index)) {
      int smallerChildIndex = leftChildIndex(index);

      if (hasRight(index) && rightChild(index) < items[smallerChildIndex]) {
        smallerChildIndex = rightChild(index);
      }

      if (items[index] < items[smallerChildIndex]) {
        break;
      } else {
        swap(index, smallerChildIndex);
        index = smallerChildIndex;
      }
    }
  }
}
