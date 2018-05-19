import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int N = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        int[] cache = new int[N + 1];

        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }

        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;
        for (int i = 4; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(cache[n[i]]);
        }

    }
}
