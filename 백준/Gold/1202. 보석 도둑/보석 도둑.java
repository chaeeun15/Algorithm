import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewelry = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken());
            jewelry[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewelry, (j1, j2) -> (j1[0] == j2[0]) ? Integer.compare(j2[1], j1[1]) : Integer.compare(j1[0], j2[0]));

        long[] C = new long[K];
        for (int i = 0; i < K; i++) {
            C[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(C);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewelry[j][0] <= C[i]) {
                maxHeap.offer(jewelry[j][1]);
                j++;
            }
            if (!maxHeap.isEmpty()) {
                ans += maxHeap.poll();
            }
        }
        System.out.println(ans);
    }
}
