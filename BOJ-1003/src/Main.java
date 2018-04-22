import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static int[][] cache;

    public static void main(String[] args) throws IOException {
        cache = new int[41][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int countZero = fib(n, 0);
            int countOne = fib(n, 1);
            System.out.println(countZero + " " + countOne);
        }
        br.close();
    }

    private static int fib(int n, int i) {
        if (n < 2) {
            return n == i ? 1 : 0;
        }

        if (0 < cache[n][i]) {
            return cache[n][i];
        }

        return cache[n][i] = fib(n - 1, i) + fib(n - 2, i);
    }

}