import java.util.*;
class Truck {
    int weight;
    int time;
    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> waiting = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) {
            waiting.offer(truck_weights[i]);
        }
        
        ArrayDeque<Truck> bridge = new ArrayDeque<>();
        int cnt = 0; // 건넌 트럭의 수
        int bridgeWeight = 0; // 현재 다리 위 트럭 무게의 합
        int time = 0; // 걸린 시간
        while (cnt < truck_weights.length) {
            time++;
            if (!bridge.isEmpty() && bridge.peek().time + bridge_length == time) {
                bridge.poll();
                bridgeWeight -= truck_weights[cnt];
                cnt++;
            }
            
            if (!waiting.isEmpty() && bridgeWeight + waiting.peek() <= weight) {
                bridge.offer(new Truck(waiting.peek(), time));
                bridgeWeight += waiting.peek();
                waiting.poll();
            }
        }
        return time;
    }
}