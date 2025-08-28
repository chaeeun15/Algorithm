import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[n + 1];
        int cnt = 0;
        queue.offer(1);
        visited[1] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list.get(cur)) {
                if (visited[next] == 0) {
                    cnt++;
                    visited[next] = 1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(cnt);
    }
}