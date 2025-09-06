import java.io.*;
import java.util.*;
class Road {
    int end;
    int weight;
    public Road(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 교차로 수
            int m = Integer.parseInt(st.nextToken()); // 도로 수
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보 수

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 출발지
            // 무조건 g <-> h 도로 지나감
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Road>> graph = new ArrayList<>();
            int[] distance = new int[n + 1];
            for (int j = 0; j < n + 1; j++) {
                graph.add(new ArrayList<>());
                distance[j] = INF;
            }
            
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if (a == g && b == h || a == h && b == g) {
                    graph.get(a).add(new Road(b, d * 2 - 1));
                    graph.get(b).add(new Road(a, d * 2 - 1));
                } else {
                    graph.get(a).add(new Road(b, d * 2));
                    graph.get(b).add(new Road(a, d * 2));
                }
            }

            int[] endPoints = new int[t];
            for (int j = 0; j < t; j++) {
                endPoints[j] = Integer.parseInt(br.readLine());
            }

            PriorityQueue<Road> minHeap = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.weight, r2.weight));
            boolean[] visited = new boolean[n + 1];

            distance[s] = 0;
            minHeap.offer(new Road(s, 0));
            
            while (!minHeap.isEmpty()) {
                Road cur = minHeap.poll();
                if (!visited[cur.end]) {
                    visited[cur.end] = true;
                    for (Road next : graph.get(cur.end)) {
                        if (!visited[next.end] && cur.weight + next.weight < distance[next.end]) {
                            distance[next.end] = cur.weight + next.weight;
                            minHeap.offer(new Road(next.end, distance[next.end]));
                        }
                    }
                }
            }
            
            Arrays.sort(endPoints);
            for (int endPoint : endPoints) {
                if (distance[endPoint] % 2 == 1) {
                    sb.append(endPoint).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
