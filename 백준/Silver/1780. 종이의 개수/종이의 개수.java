import java.io.*;
import java.util.*;
public class Main {
    static int[][] paper;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    static void recursive(int row, int col, int size) {
        if (check(row, col, size)) {
            if (paper[row][col] == -1) {
                minus++;
            } else if (paper[row][col] == 0) {
                zero++;
            } else {
                plus++;
            }
        } else {
            size /= 3;
            recursive(row, col, size);
            recursive(row, col + size, size);
            recursive(row, col + 2*size, size);
            recursive(row + size, col, size);
            recursive(row + size, col + size, size);
            recursive(row + size, col + 2*size, size);
            recursive(row + 2*size, col, size);
            recursive(row + 2*size, col + size, size);
            recursive(row + 2*size, col + 2*size, size);
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
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}