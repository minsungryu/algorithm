import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int C = 9;
    private static final int S = 100;

    private static int[] height = new int[C];
    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < C; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < C; j++) {
                if (i == j) {
                    continue;
                }

                if (sum - height[i] - height[j] == S) {
                    height[i] = height[j] = -1;
                    Arrays.sort(height);
                    StringBuffer sb = new StringBuffer();
                    for (int k = 2; k < C; k++) {
                        sb.append(height[k] + "\n");
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}

