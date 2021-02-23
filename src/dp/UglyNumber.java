package dp;

import java.security.InvalidParameterException;

public class UglyNumber {

  /*
   * Time Complexity O(n)
   */
  public int NthUglyNumberRecursive(int n) {
    if (n > 0) {
      if (n == 1) {
        return 1;
      } else {
        int candidate_ugly_num = NthUglyNumberRecursive(n - 1) + 1;
        while (!isUgly(candidate_ugly_num)) {
          candidate_ugly_num++;
        }
        return candidate_ugly_num;
      }
    } else throw new InvalidParameterException("N should be greater than 0");
  }

  public int NthUglyNumberIterative(int n) {
    if (n > 0) {
      if (n == 1) {
        return 1;
      } else {
        int candidate_ugly_num = 2;
        int ithNum = 2;

        while (ithNum != n) {
          candidate_ugly_num++;
          if (isUgly(candidate_ugly_num)) {
            ithNum++;
            System.out.println(
              "Ith: " + ithNum + " candidateNum: " + candidate_ugly_num
            );
          }
        }
        return candidate_ugly_num;
      }
    } else throw new InvalidParameterException("N should be greater than 0");
  }

  public boolean isUgly(int num) {
    if (num == 1) {
      return true;
    }

    if (num % 2 == 0) {
      while (num % 2 == 0) {
        num /= 2;
      }
    }

    if (num % 3 == 0) {
      while (num % 3 == 0) {
        num /= 3;
      }
    }

    if (num % 5 == 0) {
      while (num % 5 == 0) {
        num /= 5;
      }
    }

    return num == 1 ? true : false;
  }

  public int getNthUglyNumberWithAuxiallySpace(int n) {
    int[] ugly = new int[n];
    int i2 = 0, i3 = 0, i5 = 0;
    ugly[0] = 1;
    int next_multiple_of_2 = 2;
    int next_multiple_of_3 = 3;
    int next_multiple_of_5 = 5;
    int next_ugly_number = 1;

    for (int i = 1; i < n; i++) {
      next_ugly_number =
        Math.min(
          next_multiple_of_2,
          Math.min(next_multiple_of_3, next_multiple_of_5)
        );

      ugly[i] = next_ugly_number;
      if (next_ugly_number == next_multiple_of_2) {
        i2++;
        next_multiple_of_2 = ugly[i2] * 2;
      }
      if (next_ugly_number == next_multiple_of_3) {
        i3++;
        next_multiple_of_3 = ugly[i3] * 3;
      }
      if (next_ugly_number == next_multiple_of_5) {
        i5++;
        next_multiple_of_5 = ugly[i5] * 5;
      }
    }

    return next_ugly_number;
  }

  public static void main(String[] args) {
    int n = 1800;
    UglyNumber ug = new UglyNumber();
    System.out.println(ug.NthUglyNumberIterative(n));
    //        int nthUglyNumber = ug.getNthUglyNumberWithAuxiallySpace(n);
    //        System.out.println(nthUglyNumber);
  }
}
