import java.util.*;
class Pair {
    int x;
    int y;
    int cnt;
    public Pair(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (board[cur.y].charAt(cur.x) == 'G') {
                answer = cur.cnt;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int next_y = cur.y;
                int next_x = cur.x;
                while (0 <= next_y && next_y < board.length && 0 <= next_x && next_x < board[0].length() && board[next_y].charAt(next_x) != 'D') {
                    next_y += dy[i];
                    next_x += dx[i];
                }
                if (!visited[next_y - dy[i]][next_x - dx[i]]) {
                    visited[next_y - dy[i]][next_x - dx[i]] = true;
                    queue.offer(new Pair(next_y - dy[i], next_x - dx[i], cur.cnt + 1));
                }
            }
        }
        return answer;
    }
}