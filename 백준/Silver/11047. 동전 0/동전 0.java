import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[n - i - 1] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= k) {
                ans += k/coins[i];
                k -= coins[i] * (k/coins[i]);
            }
        }
        System.out.println(ans);
    }
}