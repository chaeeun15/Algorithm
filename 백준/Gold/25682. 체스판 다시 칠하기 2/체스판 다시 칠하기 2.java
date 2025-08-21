import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 왼쪽 위가 검은색일 때 다시 칠해야 하는 경우 1로 설정
        int[][] chess = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 0 && input.charAt(j) == 'W') {
                    chess[i][j] = 1;
                } else if ((i + j) % 2 != 0 && input.charAt(j) == 'B') {
                    chess[i][j] = 1;
                } else {
                    chess[i][j] = 0;
                }
            }
        }

        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + chess[i - 1][j - 1];
            }
        }

        // 누적합을 구한 뒤, 왼쪽 위가 검은색인 경우 다시 칠해야 하는 사각형 개수 최솟값 찾기
        int black_max = Integer.MIN_VALUE;
        int black_min = Integer.MAX_VALUE;
        for (int i = k; i < n + 1; i++) {
            for (int j = k; j < m + 1; j++) {
                int temp = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                black_max = Math.max(black_max, temp);
                black_min = Math.min(black_min, temp);
            }
        }

        // (왼쪽 위가 흰색인 경우 다시 칠해야 하는 사각형의 개수) = k*k - black_max
        int white_min = k*k - black_max;
        System.out.println(Math.min(black_min, white_min));
    }
}