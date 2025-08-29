import java.io.*;
import java.util.*;
class Tomatoes {
    int x;
    int y;
    int h;
    int time;
    public Tomatoes(int h, int y, int x, int time) {
        this.h = h;
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] boxes = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];
        ArrayDeque<Tomatoes> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    boxes[i][j][k] = input;

                    if (input == 1) {
                        visited[i][j][k] = true;
                        queue.offer(new Tomatoes(i, j, k, 0));
                    } else if (input == -1) {
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {1, 0, -1, 0, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};
        int ans = 0;
        while (!queue.isEmpty()) {
            Tomatoes cur = queue.poll();
            for (int i = 0; i< 6; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                int next_h = cur.h + dh[i];
                if (0 <= next_x && next_x < m && 0 <= next_y && next_y < n && 0 <= next_h && next_h < h) {
                    if (!visited[next_h][next_y][next_x] && boxes[next_h][next_y][next_x] == 0) {
                        visited[next_h][next_y][next_x] = true;
                        queue.offer(new Tomatoes(next_h, next_y, next_x, cur.time + 1));
                    }
                }
            }
            ans = Math.max(ans, cur.time);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!visited[i][j][k]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
