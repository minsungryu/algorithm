import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        int[] height = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input[0]);
            height[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < n; i++) {
            rank[i] += 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (weight[i] < weight[j] && height[i] < height[j]) {
                    rank[i] += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rank[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
