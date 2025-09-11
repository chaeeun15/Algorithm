import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] liquid = new long[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);
        int start = 0;
        int end = N - 1;
        long abs = 2000000000;
        long ans[] = new long[2];
        while (start < end) {
            if (Math.abs(liquid[start] + liquid[end]) < abs) {
                abs = Math.abs(liquid[start] + liquid[end]);
                ans[0] = liquid[start];
                ans[1] = liquid[end];
            }

            if (liquid[start] + liquid[end] == 0) {
                break;
            } else if (liquid[start] + liquid[end] > 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}