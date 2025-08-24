import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int visited[];
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    static void dfs(int cur) {
        count++;
        visited[cur] = count;
        for (int next : list.get(cur)) {
            if (visited[next] == 0) {
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
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(list.get(i));
        }

        dfs(r);
        for (int i = 1; i < n + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}