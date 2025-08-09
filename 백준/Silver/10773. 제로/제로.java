import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // k는 정수의 개수
        int k = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        int num;
        for (int i = 0; i < k; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int answer = 0;
        for (Integer s: stack) {
            answer += s;
        }
        System.out.println(answer);
    }
}