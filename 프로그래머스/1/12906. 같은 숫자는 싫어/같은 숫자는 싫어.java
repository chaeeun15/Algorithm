import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> arraylist = new ArrayList<>();
        int prenum = 10;
        for (Integer num: arr) {
            if (prenum != num) {
                arraylist.add(num);
            }
            prenum = num;
        }
        int[] answer = new int[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++) {
            answer[i] = arraylist.get(i);
        }
        return answer;
    }
}