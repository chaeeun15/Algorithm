import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < players.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= i) {
                queue.poll();
            }
            while (players[i] / m > queue.size()) {
                queue.offer(i + k);
                answer++;
            }
        }
        return answer;
    }
}