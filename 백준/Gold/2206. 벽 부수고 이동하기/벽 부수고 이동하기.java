import java.io.*;
import java.util.*;
class Wall {
    int x;
    int y;
    int distroyWall; // 부순 벽의 수
    public Wall(int y, int x, int distroyWall) {
        this.y = y;
        this.x = x;
        this.distroyWall = distroyWall;
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

        ArrayDeque<Wall> queue = new ArrayDeque<>();
        queue.offer(new Wall(0, 0, 0));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][][] visited = new int[n][m][2];
        visited[0][0][0] = 1;
        boolean arrive = false;
        while (!queue.isEmpty()) {
            Wall cur = queue.poll();
            if (cur.x == m - 1 && cur.y == n - 1) {
                arrive = true;
                System.out.println(visited[cur.y][cur.x][cur.distroyWall]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (0 <= next_x && next_x < m && 0 <= next_y && next_y < n) {
                    // 다음 위치가 벽이 아닌 경우 -> 이미 벽을 부쉈는지랑 상관 없이 이동 가능
                    // ex) 벽 부순 적 없음 & 다음 위치 벽 아님 -> distroyWall이 0일 때 방문한 적 없으면 방문 가능
                    // ex) 이미 벽을 부숨 -> 다음 위치에서도 무조건 distroyWall이 1이어야 함
                    if (map[next_y][next_x] == 0 && visited[next_y][next_x][cur.distroyWall] == 0) {
                        visited[next_y][next_x][cur.distroyWall] = visited[cur.y][cur.x][cur.distroyWall] + 1;
                        queue.offer(new Wall(next_y, next_x, cur.distroyWall));
                    }
                    // 다음 위치가 벽임 -> 지금까지 벽을 부순 적 없어야 방문 가능
                    else if (map[next_y][next_x] == 1 && cur.distroyWall == 0) {
                        visited[next_y][next_x][1] = visited[cur.y][cur.x][0] + 1;
                        queue.offer(new Wall(next_y, next_x, 1));
                    }
                }
            }
        }
        if (!arrive) {
            System.out.println(-1);
        }
    }
}
