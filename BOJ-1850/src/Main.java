import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

        int gcd = getGCD(a, b).intValue();
        System.out.println(ones(gcd));
    }

    public static BigInteger getGCD(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {
            return getGCD(b, a);
        }

        BigInteger q = a.remainder(b);

        if (q.equals(BigInteger.ZERO)) {
            return b;
        }

        return getGCD(b, q);
    }

    private static String ones(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('1');
        }
        return sb.toString();
    }

}
