import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wines[0]);
            System.exit(0);
        }

        int[][] dp = new int[n][3];
        dp[0][0] = wines[0];
        dp[0][1] = wines[0];
        // 두 번째 와인을 먹는데, 첫 번째 와인도 먹은 경우
        dp[1][0] = wines[1] + wines[0];
        // 두 번째 와인을 먹는데, 첫 번째 와인을 먹지 않은 경우
        dp[1][1] = wines[1];
        // 첫 번째 와인만 먹고 두 번째 와인은 먹지 않은 경우
        dp[1][2] = wines[0];
        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + wines[i];
            dp[i][1] = Math.max(dp[i - 2][0], Math.max(dp[i - 2][1], dp[i - 2][2])) + wines[i];
            dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }
        
        // 무조건 마지막 포도주를 마셔야 한다는 조건 없음
        int result = 0;
        for (int i = n - 2; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}