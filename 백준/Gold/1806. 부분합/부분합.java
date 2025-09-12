import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        //int[] arr = new int[N];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        if (sum[N] < S) {
            System.out.println(0);
            System.exit(0);
        }

        int start = 0;
        int end = 1;
        int length = N;
        while (end <= N) {
            if (sum[end] - sum[start] >= S) {
                length = Math.min(length, end - start);
                start++;
            } else if (sum[end] - sum[start] < S) {
                end++;
            }
        }
        System.out.println(length);
    }
}
