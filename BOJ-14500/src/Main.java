import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final int DIRECTION = 4;
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static int n;
    private static int m;
    private static int[][] board;
    private static boolean[][] visit;
    private static Stack<Integer[]> tetromino;

    private static final int SIZE = 4;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        visit = new boolean[n][m];
        tetromino = new Stack<>();
        max = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Integer[] p = new Integer[] { i, j };
                tetromino.push(p);
                visit[i][j] = true;
                bruteForce(SIZE, board[i][j]);
                tetromino.pop();
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void bruteForce(int size, int sum) {
        int l = tetromino.size();

        if (l == size) {
            if (max < sum) {
                max = sum;
            }
            return;
        }

        for (int i = 0; i < l; i++) {
            Integer[] t = tetromino.get(i);
            for (int d = 0; d < DIRECTION; d++) {
                int nx = t[0] + dx[d];
                int ny = t[1] + dy[d];
                Integer[] p = new Integer[] { nx, ny };
                if (inRange(nx, ny) && !visit[nx][ny]) {
                    tetromino.push(p);
                    visit[nx][ny] = true;
                    bruteForce(size, sum + board[nx][ny]);
                    tetromino.pop();
                    visit[nx][ny] = false;
                }
            }
        }

    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }

}