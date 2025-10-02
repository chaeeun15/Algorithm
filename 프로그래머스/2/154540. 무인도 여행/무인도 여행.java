import java.util.*;
class Island {
    int x;
    int y;
    int food;
    public Island(int y, int x, int food) {
        this.x = x;
        this.y = y;
        this.food = food;
    }
}

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {-1};
        
        ArrayList<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    ArrayDeque<Island> queue = new ArrayDeque<>();
                    queue.offer(new Island(i, j, maps[i].charAt(j) - '0'));
                    int totalFood = 0;
                    while (!queue.isEmpty()) {
                        Island cur = queue.poll();
                        totalFood += cur.food;
                        for (int k = 0; k < 4; k++) {
                            int next_x = cur.x + dx[k];
                            int next_y = cur.y + dy[k];
                            if (0 <= next_x && next_x < maps[0].length() && 0 <= next_y && next_y < maps.length && !visited[next_y][next_x] && maps[next_y].charAt(next_x) != 'X') {
                                visited[next_y][next_x] = true;
                                queue.offer(new Island(next_y, next_x, maps[next_y].charAt(next_x) - '0'));
                            }
                        }
                    }
                    list.add(totalFood);
                }
            }
        }
        
        if (list.size() != 0) {
            Collections.sort(list);
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}