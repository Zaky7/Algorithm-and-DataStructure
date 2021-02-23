package dp;

import java.util.ArrayList;
import java.util.Collections;

public class pizzaSlices {

  public static void PizzaSlices(int[] pizzaArray, int maximumSlices) {
    int[][] dp = new int[pizzaArray.length + 1][maximumSlices + 1];
    int n = pizzaArray.length;

    for (int R = 0; R <= n; R++) {
      for (int C = 0; C <= maximumSlices; C++) {
        if (R == 0 || C == 0) {
          dp[R][C] = 0;
          continue;
        }

        if (C - pizzaArray[R - 1] >= 0) {
          dp[R][C] =
            Math.max(
              dp[R - 1][C],
              dp[R - 1][C - pizzaArray[R - 1]] + pizzaArray[R - 1]
            );
        } else {
          dp[R][C] = dp[R - 1][C];
        }
      }
    }

    for (int R = 0; R <= n; R++) {
      for (int C = 0; C <= maximumSlices; C++) {
        System.out.print(dp[R][C] + "  ");
      }
      System.out.println();
    }

    ArrayList<Integer> result = new ArrayList<>();
    int R = dp.length - 1;
    int C = dp[0].length - 1;

    while (R != 0) {
      if (dp[R][C] > dp[R - 1][C]) {
        result.add(pizzaArray[R - 1]);
        C = C - pizzaArray[R - 1];
      }

      R--;
    }

    Collections.reverse(result);

    System.out.println(result.toString());
  }

  public static void main(String[] args) {
    int maximumSlices = 17;
    int pizzaArr[] = { 2, 5, 6, 8 };
    PizzaSlices(pizzaArr, maximumSlices);
  }
}
