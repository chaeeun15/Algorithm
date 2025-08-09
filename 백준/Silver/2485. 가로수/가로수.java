import java.io.*;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 이미 심어져 있는 가로수의 수
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n-1];
        int num1 = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num - num1;
            num1 = num;
        }

        int gcd = arr[0];
        for (int i = 1; i < n - 1; i++) {
            gcd = gcd(gcd, arr[i]);
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += (arr[i] / gcd - 1);
        }
        System.out.println(answer);
    }
}