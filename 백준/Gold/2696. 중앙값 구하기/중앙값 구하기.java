import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            sb.append((m + 1) / 2).append("\n");

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                // maxHeap에는 중간값 이하의 값들이 들어감
                if (j % 2 == 0) {
                    maxHeap.offer(Integer.parseInt(st.nextToken()));
                } else {
                    minHeap.offer(Integer.parseInt(st.nextToken()));
                }
                
                // maxHeap에는 무조건 minHeap의 최솟값보다 작은 값들만 들어가 있어야 함
                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int maxTemp = maxHeap.poll();
                        int minTemp = minHeap.poll();
                        maxHeap.offer(minTemp);
                        minHeap.offer(maxTemp);
                    }
                }

                if (j % 2 == 0) {
                    if (cnt == 9 || j == m - 1) {
                        sb.append(maxHeap.peek()).append("\n");
                        cnt = 0;
                    } else {
                        sb.append(maxHeap.peek()).append(" ");
                    }
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}