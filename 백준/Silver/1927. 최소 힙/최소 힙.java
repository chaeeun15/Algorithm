import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(minHeap.poll()).append("\n");
                }
            } else {
                minHeap.offer(input);
            }
        }
        System.out.println(sb);
    }
}