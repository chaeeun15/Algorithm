import java.io.*;
import java.util.*;
class Tomato {
    int x;
    int y;
    int time;
    public Tomato(int y, int x, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayDeque<Tomato> queue = new ArrayDeque<>();
        int[][] boxes = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                boxes[i][j] = input;
                if (input == 1) {
                    queue.offer(new Tomato(i, j, 0));
                    visited[i][j] = true;
                } else if (input == -1) {
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int ans = 0;
        while (!queue.isEmpty()) {
            Tomato cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (0 <= next_x && next_x < m && 0 <= next_y && next_y < n) {
                    if (!visited[next_y][next_x] && boxes[next_y][next_x] == 0) {
                        visited[next_y][next_x] = true;
                        queue.offer(new Tomato(next_y, next_x, cur.time + 1));
                    }
                }
            }
            ans = Math.max(ans, cur.time);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(ans);
    }
}
