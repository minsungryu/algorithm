import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int S;
    private static int answer;
    private static int[] num;
    private static boolean[] subset;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        answer = 0;
        subset = new boolean[N];
        num = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        bruteForce(N, 0, 0);
        System.out.println(S != 0 ? answer : answer - 1);
    }

    private static void bruteForce(int n, int depth, int sum) {
        if (n == depth) {
            if (sum == S) {
                answer += 1;
            }
            return;
        }

        subset[depth] = true;
        bruteForce(n, depth + 1, sum + num[depth]);
        subset[depth] = false;
        bruteForce(n, depth + 1, sum);
    }
}
