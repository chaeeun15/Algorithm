import java.util.*;
class Solution {
    ArrayList<Character>[] list;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                list[j].add(board[i].charAt(j));
            }
        }
        
        int temp = -1;
        while (temp != 0) {
            temp = 0;
            boolean[][] remove = new boolean[n][m];
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (check(i, j)) {
                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    if (remove[i][j] == true) {
                        list[i].remove(j);
                        list[i].add('X');
                        temp++;
                    }
                }
            }
            answer += temp;
        }
        return answer;
    }
    
    private boolean check(int i, int j) {
        if (list[i].get(j) != 'X' && list[i].get(j) == list[i].get(j + 1) && list[i].get(j) == list[i + 1].get(j) && list[i].get(j) == list[i + 1].get(j + 1)) {
            return true;
        }
        return false;
    }
}