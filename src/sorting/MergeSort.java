package sorting;

public class MergeSort {

  public int[] new2DArrByOrder(int[] arr, String order) {
    int[] newArr = new int[2];
    if (order == "asc") {
      if (arr[0] > arr[1]) {
        newArr[0] = arr[1];
        newArr[1] = arr[0];
      } else {
        newArr[0] = arr[0];
        newArr[1] = arr[1];
      }
    } else if (order == "desc") {
      if (arr[0] < arr[1]) {
        newArr[0] = arr[1];
        newArr[1] = arr[0];
      } else {
        newArr[0] = arr[0];
        newArr[1] = arr[1];
      }
    }
    return newArr;
  }

  public int[] mergeSort(int[] arr, String order) {
    if (arr.length <= 2) {
      if (arr.length == 1) {
        int[] newArr = new int[1];
        newArr[0] = arr[0];
        return newArr;
      } else {
        return new2DArrByOrder(arr, order);
      }
    }

    int part1 = (arr.length / 2) + ((arr.length % 2) == 0 ? 0 : 1);
    int part2 = arr.length - part1;

    int leftArr[] = createNewArr(arr, 0, part1);
    int rightArr[] = createNewArr(arr, part2, arr.length);

    System.out.println("LeftArr");
    MergeSort.printArr(leftArr);

    System.out.println("RightArr");
    MergeSort.printArr(rightArr);

    int[] leftSortedArr = mergeSort(leftArr, order);
    int[] rightSortedArr = mergeSort(rightArr, order);

    System.out.println("LeftSorted Arr");
    MergeSort.printArr(leftSortedArr);
    System.out.println("RightSorted Arr");
    MergeSort.printArr(rightSortedArr);

    return mergeSortArr(leftSortedArr, rightSortedArr);
  }

  public int[] createNewArr(int[] arr, int start, int end) {
    int newArrLen = (end - start);
    int[] newArr = new int[newArrLen];

    for (int i = 0; i < newArrLen; i++) {
      newArr[i] = arr[i + start];
    }

    return newArr;
  }

  public static void printArr(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public int[] mergeSortArr(int[] arr1, int[] arr2) {
    int[] mergeSortedArr = new int[arr1.length + arr2.length];
    int index1 = 0;
    int index2 = 0;
    int index3 = 0;

    while (index1 != arr1.length && index2 != arr2.length) {
      if (arr1[index1] <= arr2[index2]) {
        mergeSortedArr[index3++] = arr1[index1++];
      } else {
        mergeSortedArr[index3++] = arr2[index2++];
      }
    }

    if (index1 != arr1.length) {
      while (index1 != arr1.length) mergeSortedArr[index3++] = arr1[index1++];
    } else if (index2 != arr2.length) {
      while (index2 != arr2.length) mergeSortedArr[index3++] = arr2[index2++];
    }

    return mergeSortedArr;
  }

  public static void main(String args[]) {
    int[] arr = { 4, 5, 6, 1, 2, 2, 3 };
    MergeSort ms = new MergeSort();
    int[] newArr = ms.mergeSort(arr, "asc");
    MergeSort.printArr(newArr);
  }
}
