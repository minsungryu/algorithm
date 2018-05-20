import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][2];
        dp[1][0] = wine[1];
        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] != dp[i - 2] && i - 2 != 0) {
                dp[i][0] = Math.max(dp[i - 1][1] + wine[i], Math.max(dp[i - 1][0], dp[i - 1][1]));
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + wine[i];
            }
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + wine[i];
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }

}
