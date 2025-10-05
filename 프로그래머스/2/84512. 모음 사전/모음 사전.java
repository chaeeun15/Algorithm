import java.util.*;
class Solution {
    ArrayList<String> list = new ArrayList<>();
    String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    private void dfs(String temp, int length) {
        list.add(temp);
        if (length == 5) {
            return; 
        }
        for (int i = 0; i < 5; i++) {
            dfs(temp + words[i], length + 1);
        }
    }
}