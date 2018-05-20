import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int R = 0;
    private static final int G = 1;
    private static final int B = 2;
    private static final int RGB = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n + 1][RGB];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < RGB; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] cache = new int[n + 1][RGB];
        for (int i = 1; i <= n; i++) {
            cache[i][R] = Math.min(cache[i - 1][G], cache[i - 1][B]) + cost[i][R];
            cache[i][G] = Math.min(cache[i - 1][R], cache[i - 1][B]) + cost[i][G];
            cache[i][B] = Math.min(cache[i - 1][R], cache[i - 1][G]) + cost[i][B];
        }

        System.out.println(Math.min(cache[n][R], Math.min(cache[n][G], cache[n][B])));
    }
}
