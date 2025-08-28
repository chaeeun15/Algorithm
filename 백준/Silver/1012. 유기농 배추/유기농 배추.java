import java.util.*;
import java.io.*;
class Pair {
    int x;
    int y;
    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[][] visited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M = 0;
    static int N = 0;

    static void dfs(Pair cur) {
        for (int i = 0; i < 4; i++) {
            int next_x = cur.x + dx[i];
            int next_y = cur.y + dy[i];
            if (0 <= next_x && next_x < M && 0 <= next_y && next_y < N) {
                if (map[next_y][next_x] == 1 && visited[next_y][next_x] == 0) {
                    visited[next_y][next_x] = 1;
                    dfs(new Pair(next_y, next_x));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            visited = new int[N][M];
            int worm = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        worm++;
                        dfs(new Pair(i, j));
                    }
                }
            }
            sb.append(worm).append("\n");
        }
        System.out.println(sb);
    }
}
