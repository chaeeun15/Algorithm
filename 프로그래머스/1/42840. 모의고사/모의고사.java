import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        List<Integer> arraylist = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            if (a[i%a.length] == answers[i]) {
                score[0]++;
            } if (b[i%b.length] == answers[i]) {
                score[1]++;
            } if (c[i%c.length] == answers[i]) {
                score[2]++;
            }
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        if (score[0] == maxScore) {
            arraylist.add(1);
        } if (score[1] == maxScore) {
            arraylist.add(2);
        } if (score[2] == maxScore) {
            arraylist.add(3);
        }
        int[] answer = new int[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++) {
            answer[i] = arraylist.get(i);
        }
        return answer;
    }
}