import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] t;
    private static int[] p;
    private static boolean[] check;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        bruteForce(n + 1, 1, 0);
        System.out.println(max);
    }

    private static void bruteForce(int n, int day, int sum) {
        if (n <= day) {
            if (max < sum) {
                max = sum;
            }
            return;
        }
        if (day + t[day] <= n) {
            check[day] = true;
            bruteForce(n, day + t[day], sum + p[day]);
        }
        check[day] = false;
        bruteForce(n, day + 1, sum);
    }

}
