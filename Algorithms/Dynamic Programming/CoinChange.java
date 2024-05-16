import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    static int count(int[] coins, int sum, int n, int[][] dp) {
        // Base case
        if (sum == 0) { return 1; }

        // If the number of coins is 0 or sum is less than 0 then there is no way to make the sum
        if (n == 0 || sum < 0) return 0;

        // If the subproblem is previously calculated, return the result
        if (dp[n][sum] != -1) return dp[n][sum];

        // Two options for the current coin
        return dp[n][sum] = count(coins, sum - coins[n - 1], n, dp) + count(coins, sum, n - 1, dp);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = input.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; ++i) {
            coins[i] = input.nextInt();
        }

        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp) {
               Arrays.fill(row, -1);
        }
        System.out.println(count(coins, sum, n, dp));
        input.close();
    }
}
