import java.io.*;
import java.util.*;
public class Main {
    static int p = 1000000007;

    static long factorial(long n) {
        if (n <= 1) {
            return 1L;
        }
        return (factorial(n - 1) % p) * n % p;
    }

    static long pow(long base, long expo) {
        if (expo == 1) {
            return base % p;
        }
        long temp = pow(base, expo/2);
        if (expo % 2 == 1) {
            return ((temp % p) * temp % p) * base % p;
        }
        return (temp % p) * temp % p;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long numer = factorial(n);
        long denom = factorial(k) * factorial(n - k) % p;
        System.out.println(numer * pow(denom, p - 2) % p);
    }
}