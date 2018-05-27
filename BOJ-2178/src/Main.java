import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int DIRECTION = 4;
    private static int[] dx = { 1, 0, -1, 0};
    private static int[] dy = { 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] maze = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
            }
        }

        Queue<Integer[]> bfs = new LinkedList<>();
        boolean[][] visit = new boolean[n + 1][m + 1];
        bfs.add(new Integer[] { 1, 1 });
        while (!bfs.isEmpty()) {
            Integer[] next = bfs.poll();
            int x = next[0];
            int y = next[1];
            visit[x][y] = true;
            if (x == n && y == m) {
                break;
            }

            for (int d = 0; d < DIRECTION; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (inRange(n, m, nx, ny) && maze[nx][ny] == 1 && !visit[nx][ny]) {
                    maze[nx][ny] = maze[x][y] + 1;
                    bfs.add(new Integer[] { nx, ny });
                }
            }
        }

        System.out.println(maze[n][m]);
    }

    private static boolean inRange(int n, int m, int x, int y) {
        return 0 < x && x <= n && 0 < y && y <= m;
    }
}
