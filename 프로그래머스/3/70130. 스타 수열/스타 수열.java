import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // a안의 숫자의 값은 a.length보다 작기 때문에 cnt배열을 a.length로 선언 가능
        int[] cnt = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            cnt[a[i]]++;
        }
        
        for (int i = 0; i < a.length; i++) {
            // answer값보다 작으면 볼 필요 없음
            if (cnt[i] <= answer) {
                continue;
            }
            int temp = 0;
            for (int j = 0; j < a.length - 1; j++) {
                // 두 수의 값이 다르고, 두 수 중 하나가 i와 같으면
                if (a[j] != a[j + 1] && (a[j] == i || a[j + 1] == i)) {
                    temp++;
                    j++; // 스타수열의 집합이 겹치면 안되니까 j 한 칸 더 이동
                }
            }
            answer = Math.max(answer, temp);
        }
        return answer * 2;
    }
}