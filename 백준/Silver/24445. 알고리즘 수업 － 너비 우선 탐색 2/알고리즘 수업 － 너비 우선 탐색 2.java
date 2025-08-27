import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int cnt = 1;
    static int[] visited;

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next: list.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = ++cnt;
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
        int r = Integer.parseInt(st.nextToken());

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
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        visited = new int[n + 1];
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}
