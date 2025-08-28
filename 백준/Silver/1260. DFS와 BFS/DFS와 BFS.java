import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int cur) {
        sb.append(cur).append(" ");
        for (int next: list.get(cur)) {
            if (!visited_dfs[next]) {
                visited_dfs[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int next: list.get(cur)) {
                if (!visited_bfs[next]) {
                    visited_bfs[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(list.get(i));
        }

        visited_dfs = new boolean[n + 1];
        visited_dfs[v] = true;
        dfs(v);
        sb.append("\n");

        visited_bfs = new boolean[n + 1];
        visited_bfs[v] = true;
        bfs(v);

        System.out.println(sb);
    }
}
