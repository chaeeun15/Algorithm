import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        for (int i = 1; i < 101; i++) {
            if (i < 4) {
                dp[i] = 1L;
            } else if (4 <= i && i < 6) {
                dp[i] = 2L;
            } else {
                dp[i] = dp[i - 1] + dp[i - 5];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}