import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(p);

        int sum = p[0];
        for (int i = 1; i < n; i++) {
            p[i] += p[i - 1];
            sum += p[i];
        }
        System.out.println(sum);
    }
}
