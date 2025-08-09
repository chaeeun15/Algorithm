import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // t는 테스트 데이터의 개수
        int t = Integer.parseInt(br.readLine());
        Deque<String> stack;

        String input;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            input = br.readLine();
            stack = new ArrayDeque<>();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    stack.push("(");
                } else if (input.charAt(j) == ')') {
                    if (!(stack.isEmpty())) {
                        stack.pop();
                    } else {
                        stack.push(")");
                        break;
                    }
                }
            }
            
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}