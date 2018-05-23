import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int T;
    private static int N;
    private static int K;
    private static int[] D;
    private static int W;

    private static List<List<Integer>> adjacent;
    private static Stack<Integer> stack;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            D = new int[N + 1];
            input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                D[i + 1] = Integer.parseInt(input[i]);
            }

            adjacent = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjacent.add(new LinkedList<>());
            }

            for (int i = 0; i < K; i++) {
                input = br.readLine().split(" ");
                int from = Integer.parseInt(input[0]);
                int to = Integer.parseInt(input[1]);
                adjacent.get(from).add(to);
            }

            W = Integer.parseInt(br.readLine());

            stack = new Stack<>();
            visit = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                topologySort(i);
            }

            int[] dp = new int[N + 1];
            dp[1] = D[1];

            while (!stack.isEmpty()) {
                int building = stack.pop();
                List<Integer> list = adjacent.get(building);

                dp[building] = Math.max(D[building], dp[building]);
                for (int i = 0; i < list.size(); i++) {
                    int k = list.get(i);
                    dp[k] = Math.max(dp[building] + D[k], dp[k]);
                }
            }

            System.out.println(dp[W]);
        }
    }

    private static void topologySort(int v) {
        visit[v] = true;

        Iterator<Integer> it = adjacent.get(v).iterator();
        while (it.hasNext()) {
            int u = it.next();
            if (!visit[u]) {
                topologySort(u);
            }
        }
        stack.push(v);
    }

}
