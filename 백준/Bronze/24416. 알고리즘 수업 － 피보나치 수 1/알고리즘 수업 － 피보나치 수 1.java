import java.util.*;
public class Main {
    static long code1 = 0;
    static int code2 = 0;
    static int fib(int n) {
        if (n == 1 || n == 2) {
            code1++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static long fibonacci(int n) {
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        if (n == 0 || n == 1) {
            code2 = n + 1;
        }
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            code2++;
        }
        return f[n - 1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fib(n);
        fibonacci(n);
        System.out.println(code1 + " " + code2);
    }
}