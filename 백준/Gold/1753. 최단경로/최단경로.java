import java.io.*;
import java.util.*;
class Node {
    int end;
    int weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            list.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        distance[K] = 0;
        heap.offer(new Node(K, 0));
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
            }
            for (Node next : list.get(cur.end)) {
                if (!visited[next.end] && distance[cur.end] + next.weight < distance[next.end]) {
                    distance[next.end] = distance[cur.end] + next.weight;
                    heap.offer(new Node(next.end, distance[next.end]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
