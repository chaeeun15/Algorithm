import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<String> stack;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ([]).", true);
            // .만 입력받았을 때 while문 종료
            if (st.countTokens() == 1) {
                break;
            } else {
                stack = new ArrayDeque<>();
                String input;
                while (st.hasMoreTokens()) {
                    input = st.nextToken();
                    if (input.equals("(")) {
                        stack.push("(");
                    } else if (input.equals("[")) {
                        stack.push("[");
                    } else if (input.equals(")")) {
                        if (!(stack.isEmpty()) && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(")");
                            break;
                        }
                    } else if(input.equals("]")) {
                        if (!(stack.isEmpty()) && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            stack.push("]");
                            break;
                        }
                    }
                }
                if (stack.isEmpty()) {
                    sb.append("yes").append("\n");
                } else {
                    sb.append("no").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}