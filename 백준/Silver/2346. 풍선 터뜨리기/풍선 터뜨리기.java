import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 풍선의 개수
        int n = Integer.parseInt(br.readLine());
        // 풍선 번호, 종이에 적인 번호 순서
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            deque.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while (deque.size() > 1) {
            int arr[] = deque.pollFirst();
            int idx = arr[0];
            sb.append(idx).append(" ");
            int num = arr[1];
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < num*(-1); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.poll()[0]);
        System.out.println(sb);
    }
}