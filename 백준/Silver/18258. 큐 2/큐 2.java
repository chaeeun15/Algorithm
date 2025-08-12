import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 명령의 수
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if(input.equals("pop")) {
                if (!(queue.isEmpty())) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if(input.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if(input.equals("empty")) {
                if (!(queue.isEmpty())) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if(input.equals("front")) {
                if (!(queue.isEmpty())) {
                    sb.append(queue.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if(input.equals("back")) {
                if (!(queue.isEmpty())) {
                    sb.append(queue.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}