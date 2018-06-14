import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int firstRing = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int ring = Integer.parseInt(st.nextToken());
            int gcd = getGCD(firstRing, ring);
            bw.write(String.valueOf(firstRing / gcd));
            bw.write(String.valueOf("/"));
            bw.write(String.valueOf(ring / gcd));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int getGCD(int a, int b) {
        if (a < b) {
            return getGCD(b, a);
        }

        int q = a % b;
        if (q == 0) {
            return b;
        }

        return getGCD(b, q);
    }

}
