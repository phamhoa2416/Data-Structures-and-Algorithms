import java.util.*;

public class CountSortedVowelsStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int dp[][] = new int[n + 1][5];
        
        for (int j = 0; j < 5; ++j) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (j == 0) {
                    dp[i][j] =dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][4]);
        input.close();
    }
}
