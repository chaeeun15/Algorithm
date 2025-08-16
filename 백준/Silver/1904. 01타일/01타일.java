import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[1000001];
        for (int i = 0; i < n + 1; i++) {
            if (i < 3) {
                dp[i] = i;
            } else {
                dp[i] = (dp[i-1] + dp[i-2]) % 15746;
            }
        }
        System.out.println(dp[n]);
    }
}