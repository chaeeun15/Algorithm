class Solution {
    int[] answer = {0, 0};
    public boolean check(int[][] partArr) {
        for (int i = 0; i < partArr.length; i++) {
            for (int j = 0; j < partArr.length; j++) {
                if (partArr[i][j] != partArr[0][0]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void divide(int[][] curArr) {
        if (check(curArr)) {
            if (curArr[0][0] == 0) {
                answer[0] += 1;
            } else {
                answer[1] += 1;
            }
            return;
        } else {
            int[][] divideArr1 = new int[curArr.length / 2][curArr.length / 2];
            for (int i = 0; i < curArr.length / 2; i++) {
                for (int j = 0; j < curArr.length / 2; j++) {
                    divideArr1[i][j] = curArr[i][j];
                }
            }
            divide(divideArr1);
            
            int[][] divideArr2 = new int[curArr.length / 2][curArr.length / 2];
            for (int i = 0; i < curArr.length / 2; i++) {
                for (int j = 0; j < curArr.length / 2; j++) {
                    divideArr2[i][j] = curArr[i][j + curArr.length / 2];
                }
            }
            divide(divideArr2);
            
            int[][] divideArr3 = new int[curArr.length / 2][curArr.length / 2];
            for (int i = 0; i < curArr.length / 2; i++) {
                for (int j = 0; j < curArr.length / 2; j++) {
                    divideArr3[i][j] = curArr[i + curArr.length / 2][j];
                }
            }
            divide(divideArr3);
            
            int[][] divideArr4 = new int[curArr.length / 2][curArr.length / 2];
            for (int i = 0; i < curArr.length / 2; i++) {
                for (int j = 0; j < curArr.length / 2; j++) {
                    divideArr4[i][j] = curArr[i + curArr.length / 2][j + curArr.length / 2];
                }
            }
            divide(divideArr4);
        }
        return;
    }
    
    public int[] solution(int[][] arr) {
        divide(arr);
        return answer;
    }
}