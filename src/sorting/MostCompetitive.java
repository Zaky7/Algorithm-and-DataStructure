package sorting;

import java.util.Arrays;

public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];


        // nums = Arrays.stream(nums).filter(x -> x != 0).toArray();


        int n = nums.length;
        int start = 0;
        int end = n-k;
        int index = 0;

//        System.out.println("n: " + n + " k: " + k);

        int[][][] dp = new int[n][n][2];

        for(int i=0; i<n; i++) {
            dp[i][i][1] = nums[i];
            dp[i][i][0] = i;
        }

//        print3DArray(dp, n);


        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(dp[i][j-1][1] < nums[j]) {
                    dp[i][j][1] = dp[i][j-1][1];
                    dp[i][i][0] = dp[i][j-1][0];
                } else {
                    dp[i][j][1] = nums[j];
                    dp[i][j][0] = j;
                }

//                System.out.println("I: " + i + " J: " + j);

//                print3DArray(dp, n);

            }
        }



        while(index < k) {

            int minIndex = dp[start][end][0] ;
            int minVal = dp[start][end][1];

//            System.out.print("start: " + start + " end: " + end);

            // for(int i=start; i<=end; i++) {
            //     if(nums[i] < minVal) {
            //         minVal = nums[i];
            //         minIndex = i;
            //     }
            // }


//            System.out.print(" minVal: " + minVal + " minIndex: " + minIndex);
//            System.out.println();


            res[index++] = minVal;

            start = minIndex + 1;
            end = (n - k) + index;
        }

        return res;
    }

    public void print3DArray(int[][][] dp, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("[" + dp[i][j][0] + "," + dp[i][j][1] + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MostCompetitive mc = new MostCompetitive();
//        int[] nums = {3,5,2,6};
//        int k = 2;

        int[] nums = {2,4,3,3,5,4,9,6};
        int k = 4;

        int[] competitive = mc.mostCompetitive(nums,k);
        System.out.println(Arrays.toString(competitive));
    }
}

