import java.io.*;

public class Main {

    private static final int DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cache = new int[n + 1][10];

        for (int i = 1; i < cache[0].length; i++) {
            cache[1][i] = 1;
        }

        for (int i = 2; i <=n; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                if (0 < j) {
                    cache[i][j] = cache[i - 1][j - 1];
                }
                if (j < cache[i].length - 1) {
                    cache[i][j] += cache[i - 1][j + 1];
                }
                cache[i][j] %= DIV;
            }
        }

        int stairNumber = 0;
        for (int i = 0; i < cache[n].length; i++) {
            stairNumber += cache[n][i];
            stairNumber %= DIV;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(stairNumber));
        bw.flush();
        bw.close();
        br.close();
    }

}
