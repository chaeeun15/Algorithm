import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n - 1;
            int mid = (start + end) / 2;
            int num = Integer.parseInt(st.nextToken());
            boolean find = false;
            while (start <= end) {
                if (num < A[mid]) {
                    end = mid - 1;
                    mid = (start + end) / 2;
                } else if (num > A[mid]) {
                    start = mid + 1;
                    mid = (start + end) / 2;
                } else {
                    sb.append(1).append("\n");
                    find = true;
                    break;
                }
            }
            if (!find) {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
