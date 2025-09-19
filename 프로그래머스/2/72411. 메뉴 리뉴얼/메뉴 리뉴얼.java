import java.util.*;
class Solution {
    private HashMap<String, Integer> map;
    private StringBuilder sb;
    
    // num은 코스요리를 구성하는 단품메뉴들의 개수
    private void combination(String[] menus, int start, int num) {
        if (sb.length() == num) {
            map.put(sb.toString(), 0);
            return;
        }
        
        for (int i = start; i < menus.length; i++) {
            sb.append(menus[i]);
            combination(menus, i + 1, num);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
    
    public String[] solution(String[] orders, int[] course) {
        int[][] cnt = new int[orders.length][26];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                cnt[i][orders[i].charAt(j) - 65] += 1;
                if (!set.contains(orders[i].charAt(j))) {
                    set.add(String.valueOf(orders[i].charAt(j)));
                }
            }
        }
        
        String[] menus = new String[set.size()];
        Iterator<String> iter = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            menus[i] = iter.next();
        }
        
        ArrayList<String> list = new ArrayList<>();
        for (int num : course) {
            int max = 0;
            map = new HashMap<>();
            sb = new StringBuilder();
            combination(menus, 0, num);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                // System.out.println(entry.getKey() + " " + entry.getValue());
                // int tempMax = 0;
                for (int i = 0; i < orders.length; i++) {
                    int temp = 0;
                    for (int j = 0; j < num; j++) {
                        if (cnt[i][entry.getKey().charAt(j) - 65] == 1) {
                            temp++;
                        }
                    }
                    
                    // temp == num이면 hashmap의 조합이 해당 orders[i] 안에 있는 것
                    if (temp == num) {
                        map.put(entry.getKey(), entry.getValue() + 1);
                    }
                }
                max = Math.max(entry.getValue(), max);
                //System.out.println(entry.getKey() + " " + entry.getValue());
            }
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max && max > 1) {
                    list.add(entry.getKey());
                }
             }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
// orders에 나온 알파벳 중 2개를 뽑음 -> 최대 26C2
// 그 조합으로 orders를 돌면서 몇 번 나왔는지 확인 -> 최댓값 갱신(hashmap?)
// 3개 4개 등등 course 값에 따라 반복