import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // m 이상 n 이하의 소수 모두 출력하기
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = m; i < n + 1; i++) {
            int temp = 0;
            for (int j = 2; j < ((int) Math.sqrt(i)) + 1; j++) {
                if (i % j == 0) {
                    temp++;
                    break;
                }
            }
            if (temp == 0 && i != 1) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}