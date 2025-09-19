import java.util.*;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    private void hanoi(int start, int mid, int end, int n) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        hanoi(start, end, mid, n - 1);
        list.add(new int[]{start, end});
        hanoi(mid, start, end, n - 1);
    }
    
    public int[][] solution(int n) {
        hanoi(1, 2, 3, n);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
}
// n - 1개를 2번 기둥으로 옮김 + [1, 3] + n - 1개를 3번 기둥으로 옮김