import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        int start = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            long cut = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] > mid) {
                    cut += tree[i] - mid;
                }
            }
            // cut이 m보다 크면 mid가 더 커져야 함
            // upper bound
            if (cut >= m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start - 1);
    }
}