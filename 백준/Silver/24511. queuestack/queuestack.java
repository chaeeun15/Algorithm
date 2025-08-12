import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 자료구조의 개수
        int n = Integer.parseInt(br.readLine());
        
        // queue인 상황만 고려하면 됨.
        ArrayDeque<Integer> queuestack = new ArrayDeque<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int st2input = Integer.parseInt(st2.nextToken());
            if (Integer.parseInt(st1.nextToken()) == 0) {
                queuestack.offer(st2input);
            }
        }

        // m은 수열의 길이
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            queuestack.offerFirst(Integer.parseInt(st.nextToken()));
            sb.append(queuestack.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}