import java.util.*;
class Pair {
    int x;
    int y;
    boolean direction;
    int cost;
    public Pair(int x, int y, boolean direction, int cost) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cost = cost;
    }
}

class Solution {
    static final int INF = 500*25*25;
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((h1, h2) -> Integer.compare(h1.cost, h2.cost));
        
        int[][][] costs = new int[2][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[0][i][j] = INF;
                costs[1][i][j] = INF;
            }
        }
        costs[0][0][0] = 0;
        
        if (board[0][1] == 0) {
            costs[0][0][1] = 100;
            queue.offer(new Pair(1, 0, true, 100));
        }
        if (board[1][0] == 0) {
            queue.offer(new Pair(0, 1, false, 100));
            costs[1][1][0] = 100;
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (0 <= next_x && next_x < n && 0 <= next_y && next_y < n) {
                    if (board[next_y][next_x] == 0) {
                        if (cur.direction && cur.y == next_y) {
                            if (costs[0][next_y][next_x] > costs[0][cur.y][cur.x] + 100) {
                                costs[0][next_y][next_x] = costs[0][cur.y][cur.x] + 100;
                                queue.offer(new Pair(next_x, next_y, true, cur.cost + 100));
                            }
                        } else if (cur.direction && cur.x == next_x) {
                            if (costs[1][next_y][next_x] > costs[0][cur.y][cur.x] + 600) {
                                costs[1][next_y][next_x] = costs[0][cur.y][cur.x] + 600;
                                queue.offer(new Pair(next_x, next_y, false, cur.cost + 600));
                            }
                        } else if (!cur.direction && cur.y == next_y) {
                            if (costs[0][next_y][next_x] > costs[1][cur.y][cur.x] + 600) {
                                costs[0][next_y][next_x] = costs[1][cur.y][cur.x] + 600;
                                queue.offer(new Pair(next_x, next_y, true, cur.cost + 600));
                            }
                        } else if (!cur.direction && cur.x == next_x) {
                            if (costs[1][next_y][next_x] > costs[1][cur.y][cur.x] + 100) {
                                costs[1][next_y][next_x] = costs[1][cur.y][cur.x] + 100;
                                queue.offer(new Pair(next_x, next_y, false, cur.cost + 100));
                            }
                        }
                    }
                }
            }
        }
        return Math.min(costs[0][n - 1][n - 1], costs[1][n - 1][n - 1]);
    }
}