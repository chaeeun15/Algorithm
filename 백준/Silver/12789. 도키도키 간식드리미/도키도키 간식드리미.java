import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 승환이 앞에 서 있는 학생들의 수
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        for (int i = 0; i < n + 1; i++) {
            while (!(stack.isEmpty()) && stack.peek() == idx) {
                stack.pop();
                idx++;
            }
            if (!(queue.isEmpty())) {
                if (queue.peek() == idx) {
                    queue.poll();
                    idx++;
                } else {
                    stack.push(queue.poll());
                }
            }
        }

        if (stack.isEmpty() && queue.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}