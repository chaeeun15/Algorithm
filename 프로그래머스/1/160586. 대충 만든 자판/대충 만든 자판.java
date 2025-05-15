import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (map.containsKey(key.charAt(i))) { // map에 해당 char이 있다면
                    if (map.get(key.charAt(i)) > i+1) { // 이미 저장된 값보다 i+1이 작다면
                        map.put(key.charAt(i), i+1); // i+1로 업데이트
                    }
                } else {
                    map.put(key.charAt(i), i+1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                if (!map.containsKey(targets[i].charAt(j))) { // map에 없는 알파벳이면
                    sum = -1;
                    break;
                } else {
                    sum += map.get(targets[i].charAt(j));
                }
            } answer[i] = sum;
        }
        return answer;
    }
}