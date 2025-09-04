import java.io.*;
import java.util.*;
class HideSeek {
    int end;
    int time;
    public HideSeek(int end, int time) {
        this.end = end;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] result = new int[100001];
        for (int i = 0; i < 100001; i++) {
            result[i] = 100001;
        }
        result[N] = 0;

        PriorityQueue<HideSeek> minHeap = new PriorityQueue<>((h1, h2) -> Integer.compare(h1.time, h2.time));
        minHeap.offer(new HideSeek(N, 0));
        boolean[] visited = new boolean[100001];
        while(!minHeap.isEmpty()) {
            HideSeek cur = minHeap.poll();
            if (cur.end == K) {
                break;
            }
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                if (cur.end + 1 <= 100000 && !visited[cur.end + 1] && cur.time + 1 < result[cur.end + 1]) {
                    result[cur.end + 1] = cur.time + 1;
                    minHeap.offer(new HideSeek(cur.end + 1, cur.time + 1));
                }
                if (0 <= cur.end - 1 && !visited[cur.end - 1] && cur.time + 1 < result[cur.end - 1]) {
                    result[cur.end - 1] = cur.time + 1;
                    minHeap.offer(new HideSeek(cur.end - 1, cur.time + 1));
                }
                if (cur.end * 2 <= 100000 && !visited[cur.end * 2] && cur.time < result[cur.end * 2]) {
                    result[cur.end * 2] = cur.time;
                    minHeap.offer(new HideSeek(cur.end * 2, cur.time));
                }
            }
        }
        System.out.println(result[K]);
    }
}
