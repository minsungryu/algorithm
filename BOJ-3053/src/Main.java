import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double r = Double.parseDouble(br.readLine());
        br.close();

        double rSquare = Math.pow(r, 2);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(String.format("%.6f", Math.PI * rSquare)));
        bw.newLine();
        bw.write(String.valueOf(String.format("%.6f", 2f * rSquare)));
        bw.flush();
        bw.close();
    }
}
