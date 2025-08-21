import java.io.*;
public class Main {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    static void recursive(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(video[row][col]);
        } else {
            size /= 2;
            recursive(row, col, size);
            recursive(row, col + size, size);
            recursive(row + size, col, size);
            recursive(row + size, col + size, size);
            sb.append(")");
        }
    }

    static boolean check(int row, int col, int size) {
        int start = video[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[i][j] != start) {
                    sb.append("(");
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        recursive(0, 0, n);
        System.out.println(sb);
    }
}