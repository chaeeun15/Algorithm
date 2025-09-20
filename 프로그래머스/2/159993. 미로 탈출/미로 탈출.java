import java.util.*;
class Pair{
    int x;
    int y;
    int distance;
    public Pair(int y, int x, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean lever = false;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (maps[cur.y].charAt(cur.x) == 'L') {
                queue = new ArrayDeque<>();
                queue.offer(new Pair(cur.y, cur.x, 0));
                answer += cur.distance;
                lever = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (0 <= next_x && next_x < maps[0].length() && 0 <= next_y && next_y < maps.length) {
                    if (!visited[next_y][next_x] && maps[next_y].charAt(next_x) != 'X') {
                        visited[next_y][next_x] = true;
                        queue.offer(new Pair(next_y, next_x, cur.distance + 1));
                    }
                }
            }
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        boolean exit = false;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (maps[cur.y].charAt(cur.x) == 'E') {
                answer += cur.distance;
                exit = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (0 <= next_x && next_x < maps[0].length() && 0 <= next_y && next_y < maps.length) {
                    if (!visited[next_y][next_x] && maps[next_y].charAt(next_x) != 'X') {
                        visited[next_y][next_x] = true;
                        queue.offer(new Pair(next_y, next_x, cur.distance + 1));
                    }
                }
            }
        }
        
        if (lever == false || exit == false) {
            return -1;
        }
        return answer;
    }
}
// 출발점 -> 레버 + 레버 -> 출구