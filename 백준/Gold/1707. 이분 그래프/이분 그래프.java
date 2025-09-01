import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    static boolean bipartite;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int cur) {
        for (int next: list.get(cur)) {
            // 아직 방문하지 않은 노드면 현재 노드와 반대 집합으로 설정
            if (visited[next] == 0) {
                if (visited[cur] == 1) {
                    visited[next] = 2;
                } else {
                    visited[next] = 1;
                }
                dfs(next);
            }
            // 연결되어 있는 두 정점의 집합이 같으면 NO
            else if (visited[next] == visited[cur]) {
                bipartite = false;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // k는 테스트 케이스의 개수
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = 0; j < v + 1; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            visited = new int[v + 1];
            bipartite = true;
            for (int j = 1; j < v + 1; j++) {
                if (visited[j] == 0) {
                    visited[j] = 1;
                    dfs(j);
                }
            }
            
            if (bipartite) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}