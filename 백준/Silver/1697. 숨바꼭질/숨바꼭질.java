import java.io.*;
import java.util.*;
class Pairs {
    int point;
    int time;
    public Pairs(int point, int time) {
        this.point = point;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k <= n) {
            System.out.println(n - k);
            System.exit(0);
        }

        boolean[] visited = new boolean[100001];
        ArrayDeque<Pairs> queue = new ArrayDeque<>();

        queue.offer(new Pairs(n, 0));
        while (!queue.isEmpty()) {
            Pairs cur = queue.poll();
            if (cur.point == k) {
                System.out.println(cur.time);
                break;
            }
            if (0 <= cur.point - 1 && !visited[cur.point - 1]) {
                queue.offer(new Pairs(cur.point - 1, cur.time + 1));
                visited[cur.point - 1] = true;
            }
            if (cur.point + 1 <= 100000 && !visited[cur.point + 1]) {
                queue.offer(new Pairs(cur.point + 1, cur.time + 1));
                visited[cur.point + 1] = true;
            }
            if (0 < cur.point && cur.point * 2 <= 100000 && !visited[cur.point * 2]) {
                queue.offer(new Pairs(cur.point * 2, cur.time + 1));
                visited[cur.point * 2] = true;
            }
        }
    }
}