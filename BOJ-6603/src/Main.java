import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int N = 6;
    private static int k;
    private static int[] set;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
            if (k == 0) {
                break;
            }
            set = new int[k];
            check = new boolean[k];
            for (int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(input[i + 1]);
            }
            combination(k, 0);
            System.out.println();
        }
    }

    private static void combination(int n, int depth) {
        if (n == depth) {
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < k; i++) {
                if (check[i]) {
                    count += 1;
                    sb.append(set[i] + " ");
                }
            }
            if (count == N) {
                System.out.println(sb.toString().trim());
            }
            return;
        }

        check[depth] = true;
        combination(n, depth + 1);
        check[depth] = false;
        combination(n, depth + 1);
    }

}
