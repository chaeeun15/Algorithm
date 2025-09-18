class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int[] minLeft = new int[a.length];
        int minimum = 1000000001;
        for (int i = 0; i < a.length; i++) {
            minimum = Math.min(minimum, a[i]);
            minLeft[i] = minimum;
        }
        
        int[] minRight = new int[a.length];
        minimum = 1000000001;
        for (int i = a.length - 1; i >= 0; i--) {
            minimum = Math.min(minimum, a[i]);
            minRight[i] = minimum;
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] == minLeft[i] || a[i] == minRight[i]) {
                answer++;
            }
        }
        return answer;
    }
}
// 자기 자신을 기준으로 두 부분으로 나눠서
// 자기 자신이 왼쪽 배열에서 가장 작은 값이거나
// 오른쪽 배열에서 가장 작은 값이면 최후까지 남을 수 있다.