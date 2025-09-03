import java.io.*;
import java.util.*;
public class Main {
    static boolean[][] edges;
    static int[] degree;

    private static void swap(int a, int b) {
        // a가 b보다 앞에 있다면
        if (edges[a][b]) {
            // 둘의 순서를 바꿈
            edges[a][b] = false;
            edges[b][a] = true;
            // a는 뒤로 이동(degree 커짐), b는 앞으로 이동(degree 작아짐)
            degree[a] += 1;
            degree[b] -= 1;
        } else {
            edges[a][b] = true;
            edges[b][a] = false;
            degree[a] -= 1;
            degree[b] += 1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            degree = new int[n + 1];
            // edges[1][2] = true라면 1이 2보다 앞에 있는 것
            edges = new boolean[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                degree[num] = i;
                for (int j = 1; j < n + 1; j++) {
                    if (j != num && !edges[j][num]) {
                        edges[num][j] = true;
                    }
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                swap(a, b);
            }
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i < n + 1; i++) {
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }

            StringBuilder sbTemp = new StringBuilder();
            boolean possible = true;
            for (int i = 1; i < n + 1; i++) {
                // degree가 0인 원소가 없음 -> 사이클 존재
                if (queue.size() == 0) {
                    sb.append("IMPOSSIBLE").append("\n");
                    possible = false;
                    break;
                }
                // degree가 같은 원소가 여러 개 -> 순서 정확히 알 수 없음
                else if (queue.size() > 1) {
                    sb.append("?").append("\n");
                    possible = false;
                    break;
                }

                int cur = queue.poll();
                sbTemp.append(cur).append(" ");
                for (int j = 1; j < n + 1; j++) {
                    // 현재 원소보다 j가 뒤에 있으면
                    if (edges[cur][j]) {
                        // j의 degree 1 줄이고 만약 0이면 queue에 넣기
                        degree[j] -= 1;
                        if (degree[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
            }
            if (sbTemp.length() != 0 && possible) {
                sb.append(sbTemp).append("\n");
            }
        }
        System.out.println(sb);
    }
}