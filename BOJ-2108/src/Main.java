import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[] n;
    private static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        n = new int[8001];
        sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            n[num + 4000] += 1;
            sum += num;
        }
        StringBuilder answer = new StringBuilder();
        answer.append(average() + "\n");
        answer.append(mid() + "\n");
        answer.append(frequency() + "\n");
        answer.append(range() + "\n");
        System.out.println(answer.toString());
    }

    private static int average() {
        return (int) (Math.round(sum * 10d / N / 10d));
    }

    private static int mid() {
        int indexOfMid = (N + 1) / 2;
        int count = 0;
        for (int i = 0; i < n.length; i++) {
            count += n[i];
            if (indexOfMid <= count) {
                return i - 4000;
            }
        }
        return -1;
    }

    private static int frequency() {
        int count = -1;
        int ret = -1;
        boolean min = true;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > count) {
                min = true;
            } else if (n[i] == count && min) {
                min = false;
            } else {
                continue;
            }
            count = n[i];
            ret = i;
        }
        return ret - 4000;
    }

    private static int range() {
        int start = -1;
        int end = -1;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > 0) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return end - start;
    }

}
