import java.io.*;
import java.util.*;
class Knights {
    int x;
    int y;
    int cnt;
    public Knights(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];
            
            ArrayDeque<Knights> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            
            queue.offer(new Knights(start_y, start_x, 0));
            while (!queue.isEmpty()) {
                Knights cur = queue.poll();

                if (cur.x == end_x && cur.y == end_y) {
                    sb.append(cur.cnt).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int next_x = cur.x + dx[i];
                    int next_y = cur.y + dy[i];
                    if (0 <= next_x && next_x < l && 0 <= next_y && next_y < l) {
                        if (!visited[next_y][next_x]) {
                            visited[next_y][next_x] = true;
                            queue.offer(new Knights(next_y, next_x, cur.cnt + 1));
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
