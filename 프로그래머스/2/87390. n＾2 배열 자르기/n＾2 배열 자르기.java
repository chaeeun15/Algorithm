import java.util.*;
class Solution {
    public long[] solution(long n, long left, long right) {
        long[] answer = new long[(int)(right - left) + 1];
        
        for (long i = left; i <= right; i++) {
            if (i / n + 1 > i % n) {
                answer[(int)(i - left)] = i / n + 1L;
            } else {
                answer[(int)(i - left)] = i % n + 1L;
            }
        }
        return answer;
    }
}