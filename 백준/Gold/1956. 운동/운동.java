import java.util.*;
import java.io.*;
public class Main {
    static final long INF = 640000000000L;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 마을 수
        int E = Integer.parseInt(st.nextToken()); // 도로 수

        long[][] dist = new long[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = i + 1; j <= V; j++) {
                ans = Math.min(ans, dist[i][j] + dist[j][i]);
            }
        }
        
        if (ans < INF) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}