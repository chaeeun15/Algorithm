import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            heap.offer(enemy[i]);
            // 만약 지금까지 막은 적의 수가 n을 넘어가면 무적권 개수 확인
            if (n < 0) {
                // 무적권이 아직 남아있으면
                if (k > 0) {
                    // 이전의 값들 중 최대한 큰 값에 무적권을 쓰기
                    n += heap.poll();
                    k--;
                } else { // 무적권이 더 이상 없으면 종료
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}