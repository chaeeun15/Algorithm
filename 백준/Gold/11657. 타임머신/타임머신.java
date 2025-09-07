import java.io.*;
import java.util.*;
class Bus {
    int start;
    int end;
    int weight;
    public Bus(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static final int INF = 60000001;
    static Bus[] list;
    static long[] distance;
    static int N;
    static int M;

    static boolean bellmanFord(int start) {
        distance[start] = 0;
        for (int i = 0; i < N; i++) {
            // 매 반복에서 모든 간선 확인하면서 경로 갱신
            for (int j = 0; j < M; j++) {
                int cur = list[j].start;
                int next = list[j].end;
                int time = list[j].weight;
                if (distance[cur] != INF) {
                    if (distance[next] > distance[cur] + time) {
                        distance[next] = distance[cur] + time;
                        // N번째 반복에서 만약 경로가 갱신된다면 음수 사이클 존재
                        if (i == N - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new Bus[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[i] = new Bus(A, B, C);
        }

        distance = new long[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = INF;
        }

        StringBuilder sb = new StringBuilder();
        // 음수 사이클 존재하는 경우
        if (bellmanFord(1)) {
            sb.append("-1");
        } else {
            for (int i = 2; i < N + 1; i++) {
                // 1번 도시에서 도달할 수 없는 경우
                if (distance[i] == INF) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
