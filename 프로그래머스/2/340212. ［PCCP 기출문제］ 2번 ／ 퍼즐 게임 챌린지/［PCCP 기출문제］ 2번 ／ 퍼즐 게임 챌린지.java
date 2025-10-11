class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 0;
        for (int diff : diffs) {
            end = Math.max(end, diff);
        }
        
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            int time_prev = times[0];
            long sum = time_prev;
            for (int i = 1; i < times.length; i++) {
                if (diffs[i] <= mid) {
                    sum += times[i];
                } else {
                    sum += (time_prev + times[i]) * (diffs[i] - mid) + times[i];
                }
                time_prev = times[i];
            }
            
            if (sum > limit) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
