import java.util.*;
class Sit {
    int x;
    int y;
    int distance;
    public Sit(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int k = 0; k < 5; k++) {
            // 거리두기를 준수했으면 true, 준수하지 않았으면 false
            boolean possible = true;
            search:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[k][i].charAt(j) == 'P') {
                        ArrayDeque<Sit> queue = new ArrayDeque<>();
                        boolean[][] visited = new boolean[5][5];
                        queue.offer(new Sit(i, j, 0));
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            Sit cur = queue.poll();
                            if (cur.distance > 2) {
                                break;
                            }
                            if (!(cur.y == i && cur.x == j) && places[k][cur.y].charAt(cur.x) == 'P') {
                                // 경로에 X가 없는데 거리가 2 이하면 거리두기 준수 안함.
                                if (cur.distance <= 2) {
                                    possible = false;
                                    answer[k] = 0;
                                    break search;
                                }
                            }
                            for (int h = 0; h < 4; h++) {
                                int next_x = cur.x + dx[h];
                                int next_y = cur.y + dy[h];
                                if (0 <= next_x && next_x < 5 && 0 <= next_y && next_y < 5) {
                                    if (!visited[next_y][next_x]) {
                                        visited[next_y][next_x] = true;
                                        // 다음 위치가 X가 아닌 경우만 queue에 넣음.
                                        if (places[k][next_y].charAt(next_x) != 'X') {
                                            queue.offer(new Sit(next_y, next_x, cur.distance + 1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}