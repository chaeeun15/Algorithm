import java.util.*;
class Solution {
    private long factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }
        
        int nTemp = n;
        long index = k;
        for (int i = 0; i < n; i++) {
            long fact = factorial(--nTemp);
            answer[i] = list.get((int)((index - 1) / fact));
            
            list.remove(Integer.valueOf(list.get((int)((index - 1) / fact))));
            index -= (int)((index - 1) / fact) * fact;
        }
        return answer;
    }
}