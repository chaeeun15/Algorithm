import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeapP = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapM = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                minHeapP.offer(input);
            } else if (input < 0) {
                maxHeapM.offer(input);
            } else {
                if (minHeapP.isEmpty() && maxHeapM.isEmpty()) {
                    sb.append(0).append("\n");
                } else if (minHeapP.isEmpty()) {
                    sb.append(maxHeapM.poll()).append("\n");
                } else if (maxHeapM.isEmpty()) {
                    sb.append(minHeapP.poll()).append("\n");
                } else if (Math.abs(maxHeapM.peek()) > minHeapP.peek()) {
                    sb.append(minHeapP.poll()).append("\n");
                } else {
                    sb.append(maxHeapM.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}