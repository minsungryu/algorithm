import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] cache = new long[n + 1][2];
        cache[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i][0] = cache[i - 1][0] + cache[i - 1][1];
            cache[i][1] = cache[i - 1][0];
        }
        System.out.println(cache[n][0] + cache[n][1]);
    }
}
