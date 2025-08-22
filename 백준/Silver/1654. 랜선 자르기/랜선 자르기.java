import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // k는 가지고 있는 랜선의 개수
        int k = Integer.parseInt(st.nextToken());
        // n은 필요한 랜선의 개수
        int n = Integer.parseInt(st.nextToken());

        int[] wire = new int[k];
        long end = 0;
        for (int i = 0; i < k; i++) {
            wire[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, wire[i]);
        }

        end++;
        long start = 0;
        while (start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += wire[i] / mid;
            }
            // 현재 cnt 값이 n 이상이라는 건
            // 잘라야 하는 길이가 더 커져야 한다는 뜻
            if (cnt >= n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start - 1);
    }
}
