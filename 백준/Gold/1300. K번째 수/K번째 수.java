import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 0;
        int end = k;
        while (start < end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                cnt += Math.min(mid / i, n);
            }
            // cnt값이 k보다 작으면 mid가 더 커져야 함.
            // lower bound
            if (cnt < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }
}