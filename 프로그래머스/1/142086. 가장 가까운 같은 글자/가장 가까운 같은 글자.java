import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { // map에 있으면
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            } else { // map에 없으면
                answer[i] = -1;
                map.put(s.charAt(i), i);
            }
        }
        return answer;
    }
}