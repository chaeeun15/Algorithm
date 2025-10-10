import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int length = 0;
        ArrayList<Double> list = new ArrayList<>();
        list.add(0.0);
        while (k > 1) {
            if (k % 2 == 0) {
                list.add(list.get(length) + (double)k/2 + (double)(k - k/2) / 2);
                k /= 2;
            } else {
                list.add(list.get(length) + (double)k + (double)(k * 2 + 1) / 2);
                k = k * 3 + 1;
            }
            length++;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = length + ranges[i][1];
            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = list.get(end) - list.get(start);
            }
        }
        
        return answer;
    }
}