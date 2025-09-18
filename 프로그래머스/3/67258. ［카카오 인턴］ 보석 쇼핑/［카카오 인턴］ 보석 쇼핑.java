import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int term = gems.length + 1;
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        
        HashSet<String> gemType = new HashSet<>();
        for (String gem : gems) {
            if (!gemType.contains(gem)) {
                gemType.add(gem);
            }
        }
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (end < gems.length) {
            hashMap.put(gems[end], hashMap.getOrDefault(gems[end], 0) + 1);
            end++;
            while (hashMap.size() == gemType.size()) {
                if (hashMap.get(gems[start]) > 1) {
                    hashMap.put(gems[start], hashMap.get(gems[start]) - 1);
                } else {
                    hashMap.remove(gems[start]);
                }
                start++;
                if (end - start + 1 < term) {
                    answer[0] = start;
                    answer[1] = end;
                    term = end - start + 1;
                }
            }
        }
        return answer;
    }
}