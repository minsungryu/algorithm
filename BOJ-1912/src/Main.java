import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dp = new int[n + 1];
        int max = Integer.parseInt(input[0]);
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(input[i - 1]);
            dp[i] = Math.max(num + dp[i - 1], num);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
