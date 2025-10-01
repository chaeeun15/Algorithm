import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (d1, d2) -> d1[col - 1] == d2[col - 1] ? Integer.compare(d2[0], d1[0]) : Integer.compare(d1[col - 1], d2[col - 1]));
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int S_i = 0;
            for (int j = 0; j < data[0].length; j++) {
                S_i += data[i][j] % (i + 1);
            }
            answer ^= S_i;
        }
        return answer;
    }
}