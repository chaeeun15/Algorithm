import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // t는 테스트 케이스의 개수
        int t = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 1000000; i++) {
            int temp = 0;
            for (int j = 2; j < ((int) Math.sqrt(i)) + 1; j++) {
                if (i % j == 0) {
                    temp++;
                    break;
                }
            }
            if (temp == 0) {
                set.add(i);
            }
        }

        int n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j < n/2 + 1; j++) {
                if (set.contains(j) && set.contains(n - j)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}