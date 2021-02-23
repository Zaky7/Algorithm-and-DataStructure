package heap;

public class HeapSort {

  public void sort(int[] arr) {
    int size = arr.length;
    MaxIntHeap2 heap = new MaxIntHeap2(size);

    // Adding array element into heap
    for (int i = 0; i < size; i++) {
      heap.add(arr[i]);
    }

    // deleting from heap
    for (int i = size - 1; i >= 0; i--) {
      arr[i] = heap.poll();
    }
  }

  public static void main(String[] args) {
    int arr[] = { 5, 1, 3, 2, 5 };
    HeapSort heapSort = new HeapSort();
    heapSort.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
