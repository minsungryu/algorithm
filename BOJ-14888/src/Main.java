import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[] A;
    private static String[] O;
    private static String[] perm;
    private static boolean[] check;

    private static final String[] OPERATOR = { "+", "-", "*", "/" };
    private static int[] opCount = { 0, 0, 0, 0 };
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        O = new String[N - 1];
        perm = new String[N - 1];
        check = new boolean[N - 1];
        max = -1000000000;
        min = 1000000000;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int last = 0;
        for (int i = 0; i < opCount.length; i++) {
            opCount[i] = Integer.parseInt(input[i]);
            for (int j = 0; j < opCount[i]; j++) {
                O[last] = OPERATOR[i];
                last += 1;
            }
        }

        permutate(N - 1, 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void permutate(int n, int k) {
        if (k == n) {
            int result = calc();
            if (max < result) {
                max = result;
            }
            if (result < min) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < O.length; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            perm[k] = O[i];
            permutate(n, k + 1);
            check[i] = false;
        }
    }

    private static int calc() {
        int result = A[0];
        for (int i = 0; i < N - 1; i++) {
            String op = perm[i];
            int num = A[i + 1];
            switch (op) {
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "/":
                    result /= num;
                    break;
            }
        }
        return result;
    }

}
