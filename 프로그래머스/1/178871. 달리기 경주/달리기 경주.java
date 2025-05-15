import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (String calling : callings) {
            int index = map.get(calling);
            // front는 앞에 있던 사람의 이름
            String front = players[index-1];
            players[index] = front;
            players[index-1] = calling;
            
            // map 업데이트
            map.put(calling, index-1);
            map.put(front, index);
        }
        return players;
    }
}