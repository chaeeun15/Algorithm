import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(maxHeap.poll()).append("\n");
                }
            } else {
                maxHeap.offer(input);
            }
        }
        System.out.println(sb);
    }
}