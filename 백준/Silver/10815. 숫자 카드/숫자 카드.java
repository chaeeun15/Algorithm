import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n은 상근이가 가지고 있는 숫자 카드의 개수
        int n = scanner.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(scanner.nextInt(), 0);
        }

        // m은 가지고 있는 숫자 카드인지 구해야 할 정수의 개수
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            if (hm.containsKey(arr[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
