import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // a1/a2, b1/b2 형태의 분수
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();

        int lcm1 = lcm(a2, b2);
        int numerator_temp = a1*(lcm1/a2) + b1*(lcm1/b2);
        
        int lcm2 = gcd(lcm1, numerator_temp);
        int numerator = numerator_temp / lcm2;
        int denominator = lcm1 / lcm2;

        System.out.println(numerator + " " + denominator);
    }
}