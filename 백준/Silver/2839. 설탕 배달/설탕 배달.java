import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n은 상근이가 배달해야 하는 설탕의 무게
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = n;
        }
        for (int i = 0; i < n + 1; i++) {
            if (i + 3 <= n) {
                dp[i + 3] = Math.min(dp[i] + 1, dp[i + 3]);
            } if (i + 5 <= n) {
                dp[i + 5] = Math.min(dp[i] + 1, dp[i + 5]);
            }
        }
        if (dp[n] != n) {
            System.out.println(dp[n]);
        } else {
            System.out.println(-1);
        }
    }
}