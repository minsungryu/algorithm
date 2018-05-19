import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cache = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int case1 = Integer.MAX_VALUE;
            int case2 = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                case1 = Math.min(cache[i / 3], cache[i - 1]);
            }
            if (i % 2 == 0) {
                case2 = Math.min(cache[i / 2], cache[i - 1]);
            }

            cache[i] = Math.min(cache[i - 1], Math.min(case1, case2)) + 1;
        }
        System.out.println(cache[n]);
    }
}
