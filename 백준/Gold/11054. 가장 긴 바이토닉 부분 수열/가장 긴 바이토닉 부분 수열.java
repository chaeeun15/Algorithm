import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽부터 시작해서 가장 긴 증가하는 수열 찾기
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        int max1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    dp1[j] = Math.max(dp1[j], dp1[i] + 1);
                    max1 = Math.max(max1, dp1[j]);
                }
            }
        }

        // 오른쪽부터 시작해서 가장 긴 감소하는 수열 찾기
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        int max2 = 0;
        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    dp2[j] = Math.max(dp2[j], dp2[i] + 1);
                    max2 = Math.max(max2, dp2[j]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i]);
        }
        System.out.println(ans - 1);
    }
}