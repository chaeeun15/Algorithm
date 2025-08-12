import java.util.*;
import java.io.*;

public class Main {
    public static long combination(int a, int b) {
        long result = 1L;
        if (a > b/2) {
            for (int i = b; i > a; i--) {
                result *= i;
            }
            for (int i = 1; i <= (b - a); i++) {
                result /= i;
            }
        } else {
            for (int i = b; i > (b - a); i--) {
                result *= i;
            }
            for (int i = 1; i <= a; i++) {
                result /= i;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // t는 테스트 케이스의 개수
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combination(n, m)).append("\n");
        }
        System.out.println(sb);
    }
}