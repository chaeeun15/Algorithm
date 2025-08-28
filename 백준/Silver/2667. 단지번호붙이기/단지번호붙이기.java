import java.io.*;
import java.util.*;
class Pair {
    int x;
    int y;

    public Pair(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] visited = new int[n][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int group_cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    group_cnt++;
                    int house_cnt = 1;
                    ArrayDeque<Pair> queue = new ArrayDeque<>();
                    queue.offer(new Pair(i, j));
                    visited[i][j] = 1;
                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int next_x = cur.x + dx[k];
                            int next_y = cur.y + dy[k];
                            if (0 <= next_x && next_x < n && 0 <= next_y && next_y < n) {
                                if (map[next_y][next_x] == 1 && visited[next_y][next_x] == 0) {
                                    visited[next_y][next_x] = 1;
                                    house_cnt++;
                                    queue.offer(new Pair(next_y, next_x));
                                }
                            }
                        }
                    }
                    list.add(house_cnt);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(group_cnt).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
