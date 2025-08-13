import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    
    static void hanoi(int n, int a, int b, int c) {
        if (n == 1) {
            cnt++;
            sb.append(a + " " + c).append("\n");
            return;
        }
        // n-1개를 a에서 b로 옮김(c는 임시 기둥)
        hanoi(n-1, a, c, b);
        // 가장 큰 원판 1개를 a에서 c로 옮김
        cnt++;
        sb.append(a + " " + c).append("\n");
        // b로 옮긴 n-1개를 다시 c로 옮김(a는 임시 기둥)
        hanoi(n-1, b, a, c);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n은 첫 번째 장대에 쌓인 원판의 개수
        int n = scanner.nextInt();
        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
}