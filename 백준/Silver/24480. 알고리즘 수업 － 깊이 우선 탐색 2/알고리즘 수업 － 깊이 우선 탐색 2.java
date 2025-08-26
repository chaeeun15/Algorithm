import java.io.*;
import java.util.*;
public class Main {
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int count = 1;

    static void dfs(int cur) {
        visited[cur] = count;
        for (int next : graph.get(cur)) {
            if (visited[next] == 0) {
                count++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}