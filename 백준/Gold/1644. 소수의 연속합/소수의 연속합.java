import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] sum = new long[N + 1];
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i < N + 1; i++) {
            isPrime[i] = true;
        }
        
        int idx = 1;
        for (int i = 2; i < Math.sqrt(N) + 1; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N + 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            if (isPrime[i]) {
                sum[idx] = sum[idx - 1] + i;
                idx++;
            }
        }

        int start = 0;
        int end = 1;
        int ans = 0;
        while (end <= N) {
            if (sum[end] - sum[start] == N) {
                ans++;
                end++;
            } else if (sum[end] - sum[start] > N) {
                start++;
            } else {
                end++;
            }
        }
        System.out.println(ans);
    }
}
