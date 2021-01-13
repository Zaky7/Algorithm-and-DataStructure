package sorting;

import java.util.Random;

public class KthLargestElement {

    public int findKthLargestElement(int[] arr, int k) {
        int n = arr.length;

        if(k > n) {
            return -1;
        }


        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int partitionIndex = partitionArr(arr, start, end);

            System.out.println("Partition Index: " + partitionIndex + " start: " + start + " end: " + end);

            if(n - k == partitionIndex) {
                return arr[partitionIndex];
            } else if(n - k > partitionIndex) {
                // Move Right
                start = partitionIndex + 1;
            } else {
                end = partitionIndex - 1;
            }
        }

        return -1;
    }

    private int partitionArr(int[] arr, int start, int end) {
        Random rand= new Random(0);
        int pivotIndex = rand.nextInt(end-start + 1)+ start;

        int ptrIndex = start;

        swap(arr, ptrIndex, pivotIndex);

        for (int i = start; i < end; i++) {
            if (arr[i] <  arr[pivotIndex]) {
                swap(arr, ptrIndex, i);
                ptrIndex++;
            }
        }
        swap(arr, ptrIndex, pivotIndex);
        return ptrIndex;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        KthLargestElement kle = new KthLargestElement();
        int k = 1;
        int KthLargest = kle.findKthLargestElement(arr, k);
        System.out.println("Kth: " + k + " largest Element is " + KthLargest);
    }
}
