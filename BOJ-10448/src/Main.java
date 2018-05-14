import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[] K;
    private static int answer;

    private static final int TRI = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = new int[N];
        for (int i = 0; i < N; i++) {
            K[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            answer = 0;
            bruteForce(K[i], 0, 1, 0);
            System.out.println(answer);
        }
    }

    private static void bruteForce(int s, int sum, int n, int depth) {
        if (depth == TRI) {
            if (s == sum) {
                answer = 1;
            }
            return;
        }

        int t = n * (n + 1) / 2;
        if (s < t) {
            return;
        }

        bruteForce(s, sum + t, n + 1, depth + 1);
        bruteForce(s, sum + t, n, depth + 1);
        bruteForce(s, sum, n + 1, depth);
    }

}

