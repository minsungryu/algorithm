import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static char[] code = { 'E', 'A', 'B', 'C', 'D' };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cursor = 0;
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("0")) {
                    cursor += 1;
                }
            }
            bw.write(code[cursor]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
