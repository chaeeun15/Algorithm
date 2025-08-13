import java.util.*;
public class Main {
    static char[][] arr;

    public static void recursive(int x, int y, int n, boolean blank) {
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int cnt = 0;
        for (int i = x; i < x + n; i += n/3) {
            for (int j = y; j < y + n; j += n/3) {
                cnt++;
                if (cnt == 5) {
                    recursive(i, j, n/3, true);
                } else {
                    recursive(i, j, n/3, false);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new char[n][n];

        recursive(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}