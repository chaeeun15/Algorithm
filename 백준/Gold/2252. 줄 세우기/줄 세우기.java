import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            degree[b] += 1;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int next: list.get(cur)) {
                degree[next] -= 1;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
