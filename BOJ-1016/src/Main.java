import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int length = (int)Math.min(max, 1000000) + 1;

        boolean[] prime = new boolean[length];
        boolean[] squareNumber = new boolean[length];

        Arrays.fill(prime, true);

        for (long i = 2; i < length; i++) {
            if (!prime[(int)i]) {
                continue;
            }

            for (long j = 2 * i; j < length; j += i) {
                prime[(int)i] = false;
            }

            long pow = i * i;
            long square = min % pow;
            boolean isSquare = square == 0;
            for (long j = isSquare ? min : min + pow - square; j <= max; j += pow) {
                if (j % pow == 0) {
                    squareNumber[(int)(j - min)] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!squareNumber[i]) {
                count += 1;
            }
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}
