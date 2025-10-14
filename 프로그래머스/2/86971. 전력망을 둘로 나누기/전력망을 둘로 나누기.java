import java.util.*;
class Solution {
    private int cnt = 0;
    private ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            list[v1].remove(Integer.valueOf(v2));
            list[v2].remove(Integer.valueOf(v1));
            
            boolean[] visited = new boolean[n + 1];
            
            cnt = 0;
            dfs(1, visited);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        return answer;
    }
    
    private void dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        cnt++;
        for (int next : list[cur]) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }
}