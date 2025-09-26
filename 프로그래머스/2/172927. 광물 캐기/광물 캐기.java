import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int pickSum = 0;
        for (int i = 0; i < 3; i++) {
            pickSum += picks[i];
        }
        
        HashMap<String, Integer> mineralMap = new HashMap<>();
        mineralMap.put("diamond", 25);
        mineralMap.put("iron", 5);
        mineralMap.put("stone", 1);
        
        ArrayList<Map.Entry<Integer, String[]>> list = new ArrayList<>();
        for (int i = 0; i < minerals.length / 5 + 1 && i < pickSum; i++) {
            int temp = 0;
            String[] tempMinerals = new String[Math.min(5, minerals.length - i * 5)];
            for (int j = 0; j < 5 && i * 5 + j < minerals.length; j++) {
                temp += mineralMap.get(minerals[i * 5 + j]);
                tempMinerals[j] = minerals[i * 5 + j];
            }
            list.add(Map.entry(temp, tempMinerals));
        }
        
        list.sort(Map.Entry.comparingByKey(Collections.reverseOrder()));
        
        int dia = 0;
        int iron = 1;
        int stone = 2;
        for (Map.Entry<Integer, String[]> entry : list) {
            if (picks[dia] > 0) {
                picks[dia]--;
                for (int i = 0; i < entry.getValue().length; i++) {
                    answer += 1;
                }
            } else if (picks[iron] > 0) {
                picks[iron]--;
                for (int i = 0; i < entry.getValue().length; i++) {
                    if (entry.getValue()[i].equals("diamond")) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
            } else if (picks[stone] > 0) {
                picks[stone]--;
                for (int i = 0; i < entry.getValue().length; i++) {
                    if (entry.getValue()[i].equals("diamond")) {
                        answer += 25;
                    } else if (entry.getValue()[i].equals("iron")) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }
}