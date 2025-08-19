import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n은 전깃줄의 개수
        int n = Integer.parseInt(br.readLine());
        int[][] wire = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wire, (w1, w2) -> Integer.compare(w1[0], w2[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (wire[j][1] < wire[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(n - max);
    }
}
