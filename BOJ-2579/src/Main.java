import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[][] cache = new int[n + 1][2];
        cache[1][0] = stair[1];
        for (int i = 2; i <= n; i++) {
            if (cache[i - 1][0] != cache[i - 2][0] && i - 2 != 0) {
                cache[i][0] = cache[i - 1][1] + stair[i];
            } else {
                cache[i][0] = Math.max(cache[i - 1][0], cache[i - 1][1]) + stair[i];
            }

            cache[i][1] = Math.max(cache[i - 2][0], cache[i - 2][1]) + stair[i];
        }

        System.out.println(Math.max(cache[n][0], cache[n][1]));

    }
}
