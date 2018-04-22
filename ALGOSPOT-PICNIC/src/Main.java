import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int m;
    private static boolean[][] friend;
    private static boolean[] pair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int testcase = 0; testcase < t; testcase++) {
            String[] input = br.readLine().trim().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            friend = new boolean[n][n];
            String[] pairs = br.readLine().trim().split(" ");
            for (int i = 0; i < m * 2; i += 2) {
                int p = Integer.parseInt(pairs[i]);
                int q = Integer.parseInt(pairs[i + 1]);
                friend[p][q] = friend[q][p] = true;
            }

            pair = new boolean[n];
            System.out.println(makePair());
        }
    }

    private static int makePair() {
        int p = 0;
        boolean done = true;

        for (int i = 0; i < n; i++) {
            if (!pair[i]) {
                p = i;
                done = false;
                break;
            }
        }

        if (done) {
            return 1;
        }

        int count = 0;
        for (int q = p + 1; q < n; q++) {
            if (friend[p][q] && !pair[p] && !pair[q]) {
                pair[p] = pair[q] = true;
                count += makePair();
                pair[p] = pair[q] = false;
            }
        }

        return count;
    }

}
