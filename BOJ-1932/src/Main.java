import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n + 1][];
        triangle[0] = new int[1];
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            triangle[i] = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i - 1][j] + Integer.parseInt(input[j]);
                } else if (j == input.length - 1) {
                    triangle[i][j] = triangle[i - 1][j - 1] + Integer.parseInt(input[j]);
                } else {
                    triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + Integer.parseInt(input[j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < triangle[n].length; i++) {
            if (max < triangle[n][i]) {
                max = triangle[n][i];
            }
        }
        System.out.println(max);
    }
}
