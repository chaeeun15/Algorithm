import java.io.*;
import java.util.*;
class Nodes {
    int end;
    int weight;
    public Nodes(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Nodes>> list = new ArrayList<>();
        int[] distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
            distance[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Nodes(b, c));
            list.get(b).add(new Nodes(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        // 1 -> v2 -> v1 -> N

        // 1 -> v2랑 1 -> v1 구하기
        PriorityQueue<Nodes> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        boolean[] visited = new boolean[N + 1];
        queue.offer(new Nodes(1, 0));
        distance[1] = 0;
        while(!queue.isEmpty()) {
            Nodes cur = queue.poll();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                for (Nodes next : list.get(cur.end)) {
                    if (!visited[next.end] && cur.weight + next.weight < distance[next.end]) {
                        distance[next.end] = cur.weight + next.weight;
                        queue.offer(new Nodes(next.end, distance[next.end]));
                    }
                }
            }
        }
        int oneToV1 = distance[v1];
        int oneToV2 = distance[v2];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = INF;
        }
        
        // v2 -> v1 or v1 -> v2
        queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        visited = new boolean[N + 1];
        queue.offer(new Nodes(v1, 0));
        distance[v1] = 0;
        while(!queue.isEmpty()) {
            Nodes cur = queue.poll();
            if (cur.end == v2) {
                break;
            }
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                for (Nodes next : list.get(cur.end)) {
                    if (!visited[next.end] && cur.weight + next.weight < distance[next.end]) {
                        distance[next.end] = cur.weight + next.weight;
                        queue.offer(new Nodes(next.end, distance[next.end]));
                    }
                }
            }
        }
        int v1ToV2 = distance[v2];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = INF;
        }

        // v1 -> N, v2 -> N 구하기
        queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        visited = new boolean[N + 1];
        queue.offer(new Nodes(N, 0));
        distance[N] = 0;
        while(!queue.isEmpty()) {
            Nodes cur = queue.poll();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                for (Nodes next : list.get(cur.end)) {
                    if (!visited[next.end] && cur.weight + next.weight < distance[next.end]) {
                        distance[next.end] = cur.weight + next.weight;
                        queue.offer(new Nodes(next.end, distance[next.end]));
                    }
                }
            }
        }
        int v1ToN = distance[v1];
        int v2ToN = distance[v2];

        if (oneToV1 + v1ToV2 + v2ToN >= INF && oneToV2 + v1ToV2 + v1ToN >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(oneToV1 + v1ToV2 + v2ToN, oneToV2 + v1ToV2 + v1ToN));
        }
    }
}
