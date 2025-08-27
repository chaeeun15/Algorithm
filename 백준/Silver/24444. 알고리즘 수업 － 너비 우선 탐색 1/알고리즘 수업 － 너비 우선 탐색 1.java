import java.io.*;
import java.util.*;
public class Main {
    static int[] visited;
    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = cnt++;
            for (int next : list.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = 1;
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
            Collections.sort(list.get(i));
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