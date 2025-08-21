import java.io.*;
import java.util.*;
public class Main {
    static int blue_cnt = 0;
    static int white_cnt = 0;
    static int[][] paper;

    static void recursive(int row, int col, int size) {
        // 모든 칸이 같은 색이라면
        if (check(row, col, size)) {
            if (paper[row][col] == 1) {
                blue_cnt++;
            } else {
                white_cnt++;
            }
        } else { // 모든 칸이 같은 색이 아니라면
            size /= 2; // 사이즈를 절반으로 줄이고 더 작은 정사각형 4개 탐색
            recursive(row, col, size);
            recursive(row, col + size, size);
            recursive(row + size, col, size);
            recursive(row + size, col + size, size);
        }
    }

    static boolean check(int row, int col, int size) {
        int start = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, n);
        System.out.println(white_cnt);
        System.out.println(blue_cnt);
    }
}