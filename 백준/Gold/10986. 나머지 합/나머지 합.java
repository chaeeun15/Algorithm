import java.io.*;
import java.util.*;
public class Main {
    // nC2를 구하는 메서드
    static long comb(long n) {
        if (n <= 1) {
            return 0;
        }
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] sum = new long[n + 1];
        long[] remainder = new long[m];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            remainder[(int) (sum[i] % m)] += 1;
        }

        long ans = remainder[0];
        for (int i = 0; i < m; i++) {
            ans += comb(remainder[i]);
        }
        System.out.println(ans);
    }
}