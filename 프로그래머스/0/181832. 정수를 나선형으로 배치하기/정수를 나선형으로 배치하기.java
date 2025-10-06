class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cnt = 1;
        int i = 0;
        int j = 0;
        
        while (cnt <= n * n) {
            while (0 <= j && j < n && answer[i][j] == 0) {
                answer[i][j] = cnt;
                j++;
                cnt++;
            }
            j--;
            i++;
            while (0 <= i && i < n && answer[i][j] == 0) {
                answer[i][j] = cnt;
                i++;
                cnt++;
            }
            i--;
            j--;
            while (0 <= j && j < n && answer[i][j] == 0) {
                answer[i][j] = cnt;
                j--;
                cnt++;
            }
            j++;
            i--;
            while (0 <= i && i < n && answer[i][j] == 0) {
                answer[i][j] = cnt;
                i--;
                cnt++;
            }
            i++;
            j++;
        }
        return answer;
    }
}