import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int c = scanner.nextInt();
        int n0 = scanner.nextInt();
        if (a1 - c > 0) {
            System.out.println(0);
        } else if ((a1 - c) * n0 <= -a2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}