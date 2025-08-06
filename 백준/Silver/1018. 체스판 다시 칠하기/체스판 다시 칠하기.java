import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] chess = new String[n];
        for (int i = 0; i < n; i++) {
            chess[i] = scanner.nextLine();
        }
        int answer = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int answerW = 0;
                int answerB = 0;
                int temp = 0;
                for (int y = i; y < i + 8; y++) {
                    for (int x = j; x < j + 8; x++) {
                        if (x < m && y < n) {
                            // 첫 번째 칸이 W인 경우
                            if ((y + x) % 2 == 0 && chess[y].charAt(x) != 'W') {
                                answerW++;
                            } else if ((y + x) % 2 != 0 && chess[y].charAt(x) != 'B') {
                                answerW++;
                            }
                            // 첫 번째 칸이 B인 경우
                            if ((y + x) % 2 == 0 && chess[y].charAt(x) != 'B') {
                                answerB++;
                            } else if ((y + x) % 2 != 0 && chess[y].charAt(x) != 'W') {
                                answerB++;
                            }
                        } else {
                            temp++;
                        }
                    }
                }
                // 8*8의 체스판을 만들 수 있는 경우에만 answer 갱신
                if (temp == 0) {
                    answer = Math.min(answer, Math.min(answerW, answerB));
                }
            }
        }
        System.out.println(answer);
    }
}