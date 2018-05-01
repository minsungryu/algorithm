import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int WALLS = 3;
    private static int n;
    private static int m;
    private static int[][] lab;
    private static List<Integer[]> virus;
    private static int max;
    private static int safezone;

    private static final int DIRECTION = 4;
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        lab = new int[n][m];
        virus = new LinkedList<>();
        safezone = 0;
        max = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int type = Integer.parseInt(line[j]);
                lab[i][j] = type;
                if (type == 0) {
                    safezone += 1;
                } else if (type == 2) {
                    virus.add(new Integer[] { i, j });
                }
            }
        }

        bruteForce(WALLS, 0);
        System.out.println(max);

        br.close();
    }

    private static void bruteForce(int total, int wall) {
        if (total == wall) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    safezone -= 1;
                    bruteForce(total, wall + 1);
                    lab[i][j] = 0;
                    safezone += 1;
                }
            }
        }
    }

    private static void spreadVirus() {
        Queue<Integer[]> bfs = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        bfs.addAll(virus);
        while (!bfs.isEmpty()) {
            Integer[] current = bfs.poll();
            int x = current[0];
            int y = current[1];

            visit[x][y] = true;

            for (int d = 0; d < DIRECTION; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!inRange(nx, ny)) {
                    continue;
                }

                if (lab[nx][ny] == 0 && !visit[nx][ny]) {
                    bfs.add(new Integer[] { nx, ny });
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0 && !visit[i][j]) {
                    count += 1;
                }
            }
        }
        if (max < count) {
            max = count;
        }
    }

    private static boolean inRange(int i, int j) {
        return (0 <= i && i < n) && (0 <= j && j < m);
    }

}
