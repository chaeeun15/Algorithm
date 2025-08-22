import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] house = new long[n];
        for (int i = 0; i < n; i++) {
            house[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(house);

        long start = 1;
        long end = house[n - 1] - house[0] + 1;
        while (start < end) {
            long mid = (start + end) / 2;
            long cnt = 1;
            long pre = house[0];
            for (int i = 0; i < n - 1; i++) {
                if (house[i + 1] - pre >= mid) {
                    cnt++;
                    pre = house[i + 1];
                }
            }
            // cnt가 c보다 크면 거리를 더 늘려야 함
            if (cnt >= c) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start - 1);
    }
}