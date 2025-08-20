import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + p[i - 1];
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans += sum[i];
        }
        System.out.println(ans);
    }
}