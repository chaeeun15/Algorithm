import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n은 창문과 사람의 개수
        int n = scanner.nextInt();
        int count = 1;

        // 제곱수이면 열려있음
        while (count <= Math.sqrt(n)) {
            count++;
        }

        System.out.println(count - 1);
    }
}