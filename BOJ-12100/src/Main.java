import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOVE = 5;
    private static final int DIRECTION = 4;
    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };

    private static int N;
    private static int[][] board;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        max = 0;
        bruteForce(board, MOVE, 0);
        System.out.println(max);
    }

    private static void bruteForce(int[][] board, int n, int depth) {
        if (n == depth) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max < board[i][j]) {
                        max = board[i][j];
                    }
                }
            }
            return;
        }

        for (int d = 0; d < DIRECTION; d++) {
            int[][] copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, N);
            }
            bruteForce(move(copy, d), n, depth + 1);
        }
    }

    private static int[][] move(int[][] board, int d) {
        boolean[][] merge = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int r = d % 2 == 0 ? i : j;
                int c = d % 2 == 0 ? j : i;

                if (d < 2) {
                    if (d % 2 == 0) {
                        c = N - 1 - c;
                    } else {
                        r = N - 1 - r;
                    }
                }

                if (board[r][c] == 0) {
                    continue;
                }

                int nr = r + dy[d];
                int nc = c + dx[d];

                if (!inRange(nr, nc)) {
                    continue;
                }

                while (board[nr][nc] == 0) {
                    if (inRange(nr + dy[d], nc + dx[d])) {
                        nr += dy[d];
                        nc += dx[d];
                    } else {
                        break;
                    }
                }

                if (board[nr][nc] == 0) {
                    board[nr][nc] = board[r][c];
                    board[r][c] = 0;
                } else {
                    if (!merge[nr][nc] && board[nr][nc] == board[r][c]) {
                        merge[nr][nc] = true;
                        board[nr][nc] *= 2;
                        board[r][c] = 0;
                    } else {
                        nr -= dy[d];
                        nc -= dx[d];
                        if (!(nr == r && nc == c)) {
                            board[nr][nc] = board[r][c];
                            board[r][c] = 0;
                        }
                    }
                }
            }
        }

        return board;
    }

    private static boolean inRange(int i, int j) {
        return (0 <= i && i < N) && (0 <= j && j < N);
    }

}
