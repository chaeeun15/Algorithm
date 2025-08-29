import java.io.*;
import java.util.*;
class Dice {
    int x;
    int cnt;
    public Dice(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladder = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder.put(a, b);
        }

        HashMap<Integer, Integer> snake = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snake.put(a, b);
        }

        boolean[] visited = new boolean[101];
        ArrayDeque<Dice> queue = new ArrayDeque<>();
        queue.offer(new Dice(1, 0));
        while (!queue.isEmpty()) {
            Dice cur = queue.poll();
            if (cur.x == 100) {
                System.out.println(cur.cnt);
                break;
            }

            for (int i = 6; i > 0; i--) {
                if (snake.containsKey(cur.x + i) && !visited[snake.get(cur.x + i)]) {
                    queue.offer(new Dice(snake.get(cur.x + i), cur.cnt + 1));
                    visited[snake.get(cur.x + i)] = true;
                } else if (ladder.containsKey(cur.x + i) && !visited[ladder.get(cur.x + i)]) {
                    queue.offer(new Dice(ladder.get(cur.x + i), cur.cnt + 1));
                    visited[ladder.get(cur.x + i)] = true;
                } else if (cur.x + i <= 100 && !visited[cur.x + i] && !snake.containsKey(cur.x + i) && !ladder.containsKey(cur.x + i)){
                    queue.offer(new Dice(cur.x + i, cur.cnt + 1));
                    visited[cur.x + i] = true;
                }
            }
        }
    }
}