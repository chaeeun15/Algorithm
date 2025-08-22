import java.io.*;
public class Main {
    static long[][] recursive(long[][] A, long num) {
        if (num <= 1) {
            return A;
        }
        long[][] temp = recursive(A, num/2);
        if (num % 2 == 1) {
            return multiply(multiply(temp, temp), A);
        }
        return multiply(temp, temp);
    }

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] += (A[i][k] * B[k][j]) % 1000000007;
                }
                C[i][j] %= 1000000007;
            }
        }
        return C;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] origin = {{1, 1}, {1, 0}};
        System.out.println(recursive(origin, n - 1)[0][0] % 1000000007);
    }
}