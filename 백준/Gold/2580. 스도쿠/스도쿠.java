import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr = new int[9][9];

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        // 이 위치의 값이 0이라면 이 위치에 1~9 중 들어갈 수 있는 숫자가 있는지 확인
        if (arr[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (check(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            // 만약 check 메서드를 다 확인했는데도 true가 나오지 않으면
            // 이전에 정한 값에 문제가 있었다는 뜻이므로 현재 값을 0으로 설정한 뒤
            // 이전 재귀 호출로 돌아가서 for문을 다시 돌면서 i 값을 증가시킴.
            arr[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    public static boolean check(int x, int y, int value) {
        // 세로줄 확인
        for (int i = 0; i < 9; i++) {
            if (value == arr[i][y]) {
                return false;
            }
        }
        // 가로줄 확인
        for (int j = 0; j < 9; j++) {
            if (value == arr[x][j]) {
                return false;
            }
        }
        // 현재 위치가 포함된 사각형의 왼쪽 위의 위치
        int start_x = (x / 3) * 3;
        int start_y = (y / 3) * 3;
        // 정사각형 확인
        for (int i = start_x; i < start_x + 3; i++) {
            for (int j = start_y; j < start_y + 3; j++) {
                if (value == arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0);
    }
}