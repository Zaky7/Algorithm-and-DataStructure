package binarysearch;

public class MedianOfSortedArrays {

  public int medianOfSortedArrays(int[] arr1, int[] arr2) {
    int M = arr1.length;
    int N = arr2.length;
    int median = 0;
    for (int partitionX = 1; partitionX < M; partitionX++) {
      int partitionY = greaterElementIndex(arr2, arr1[partitionX - 1]);

      if (
        arr1[partitionX - 1] < arr2[partitionY] &&
        arr1[partitionX] > arr2[partitionY - 1]
      ) {
        if ((N + M) % 2 != 0) {
          median =
            (
              Math.max(arr1[partitionX], arr2[partitionY - 1]) +
              Math.min(arr1[partitionX + 1], arr2[partitionY])
            ) /
            2;
        } else {
          median = Math.max(arr1[partitionX], arr2[partitionY - 1]);
        }
      }
    }
    return median;
  }

  public int greaterElementIndex(int[] arr, int target) {
    return greaterElementIndex(arr, 0, arr.length - 1, target);
  }

  private int greaterElementIndex(int[] arr, int start, int end, int target) {
    int midIndex = (start + end) / 2;

    System.out.println(
      "Start: " +
      start +
      " End: " +
      end +
      " Target: " +
      target +
      " Mid: " +
      midIndex
    );

    if (arr[midIndex] > target) {
      if (midIndex > 0 && arr[midIndex - 1] > target) {
        // Move left
        return greaterElementIndex(arr, start, midIndex - 1, target);
      } else {
        return midIndex;
      }
    } else {
      if (midIndex < end && arr[midIndex + 1] >= target) {
        // Move Right
        return greaterElementIndex(arr, midIndex + 1, end, target);
      } else {
        return midIndex;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2 };
    int[] arr2 = { 3, 4 };
    MedianOfSortedArrays ms = new MedianOfSortedArrays();
    System.out.println(ms.medianOfSortedArrays(arr, arr2));
  }
}
