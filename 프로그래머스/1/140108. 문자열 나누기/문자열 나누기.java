import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = ' ';
        int x_num = 0;
        int other_num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x_num == 0){
                x = s.charAt(i);
            }
            if (s.charAt(i) == x) {
                x_num++;
                continue;
            }
            other_num++;
            if (other_num == x_num) {
                answer++;
                x_num = 0;
                other_num = 0;
            }
        }
        if (other_num != x_num) {
            answer++;
        }
        return answer;
    }
}