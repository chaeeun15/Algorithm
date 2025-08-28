import java.util.*;
import java.io.*;
class Maze {
    int x;
    int y;
    int distance;
    public Maze(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayDeque<Maze> queue = new ArrayDeque<>();
        queue.offer(new Maze(0, 0, 1));
        int[][] visited = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Maze cur = queue.poll();
            if (cur.x == m - 1 && cur.y == n - 1) {
                System.out.println(cur.distance);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (0 <= next_x && next_x < m && 0 <= next_y && next_y < n) {
                    if (map[next_y][next_x] == 1 && visited[next_y][next_x] == 0) {
                        visited[next_y][next_x] = 1;
                        queue.offer(new Maze(next_y, next_x, cur.distance + 1));
                    }
                }
            }
        }
    }
}
