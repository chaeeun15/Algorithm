import java.util.*;
class Node {
    int end;
    int weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N + 1];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        
        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        heap.offer(new Node(1, 0));
        distance[1] = 0;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            if (cur.weight > distance[cur.end]) {
                continue;
            }
            
            for (Node next : list.get(cur.end)) {
                if (distance[next.end] > distance[cur.end] + next.weight) {
                    distance[next.end] = distance[cur.end] + next.weight;
                    heap.offer(new Node(next.end, distance[next.end]));
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}