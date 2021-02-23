package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> getList(int[] nums) {
    List<Integer> list = new ArrayList<>(nums.length);
    for (int num : nums) {
      list.add(num);
    }

    System.out.println(list.toString());
    return list;
  }

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int total_sum = Arrays.stream(nums).sum();
    int n = nums.length;
    if (k == 0 || total_sum % k != 0) {
      return false;
    }
    return canPartition(0, nums, new boolean[n], k, 0, total_sum / k);
  }

  private boolean canPartition(
    int iterationStart,
    int[] arr,
    boolean[] used,
    int k,
    int inProgressBucketSum,
    int targetBucketSum
  ) {
    if (k == 1) {
      return true;
    }

    if (inProgressBucketSum == targetBucketSum) {
      return canPartition(0, arr, used, k - 1, 0, targetBucketSum);
    }

    for (int i = iterationStart; i < arr.length; i++) {
      if (!used[i]) {
        used[i] = true; // choose
        if (
          canPartition(
            i + 1,
            arr,
            used,
            k,
            inProgressBucketSum + arr[i],
            targetBucketSum
          )
        ) {
          return true;
        }
        used[i] = false; // unchoose
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //        int[] nums = {4,3,2,3,5,2,1}; int k=4;
    //        int[] nums = {-1,2,7,2,1,-7,2}; int k=4;
    int[] nums = { 10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6 };
    int k = 3;
    Solution s = new Solution();
    boolean asn = s.canPartitionKSubsets(nums, k);
    System.out.println(asn);
  }
}
