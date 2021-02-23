package sorting;

import java.util.Random;

public class QuickSort {

  public void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public boolean compare(int a, int b, String order) {
    if (order.equals("desc")) {
      return a > b;
    } else {
      return a <= b;
    }
  }

  public int findPivotIndex(int[] arr, int start, int end) {
    //    int pivotIndex = end;
    Random rand = new Random();
    int pivotIndex = rand.nextInt(end - start) + start;

    int ptrIndex = start;
    for (int i = start; i < end; i++) {
      if (compare(arr[i], arr[pivotIndex], "desc")) {
        swap(arr, ptrIndex, i);
        ptrIndex++;
      }
    }
    swap(arr, ptrIndex, pivotIndex);
    return ptrIndex;
  }

  public void quickSortUtil(int[] arr, int start, int end) {
    if (start < end) {
      int partitionIndex = findPivotIndex(arr, start, end);
      quickSortUtil(arr, start, partitionIndex - 1);
      quickSortUtil(arr, partitionIndex + 1, end);
    }
  }

  public void quickSort(int[] arr) {
    int start = 0;
    System.out.println("ArrLength: " + arr.length);
    int end = arr.length - 1;
    quickSortUtil(arr, start, end);
  }

  public static void printArr(int[] arr) {
    System.out.println();
    for (int i = 0, n = arr.length; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 6, 7, 1, 4, 5, 6 };
    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(arr);
    printArr(arr);
  }
}
