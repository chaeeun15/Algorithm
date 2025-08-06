import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
                arr[i][j+2] = arr[i][j] + 10;
            }
        }

        int[][] paper = new int[100][100];
        int answer = 0;
        for (int[] row : arr) {
            for (int i = row[0]; i < row[2]; i++) {
                for (int j = row[1]; j < row[3]; j++) {
                    if (paper[i][j] == 0) {
                        paper[i][j] = 1;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
