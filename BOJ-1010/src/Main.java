import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[][] cache = new int[30][30];

    public static void main(String[] args) throws IOException {
        getCombinations();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(cache[m][n]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getCombinations() {
        for (int n = 1; n < 30; n++) {
            for (int r = 1; r <= n; r++) {
                if (n == r) {
                    cache[n][r] = 1;
                    continue;
                }
                if (r == 1) {
                    cache[n][r] = n;
                    continue;
                }
                cache[n][r] = cache[n - 1][r] + cache[n - 1][r - 1];
            }
        }
    }

}
