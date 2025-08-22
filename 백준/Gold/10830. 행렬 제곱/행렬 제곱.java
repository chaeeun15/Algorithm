import java.io.*;
import java.util.*;
public class Main {
    static int N;

    static long[][] recursive(long[][] a, long expo) {
        if (expo == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] %= 1000;
                }
            }
            return a;
        }
        long[][] temp = recursive(a, expo/2);
        if (expo % 2 == 1) {
            return multiply(multiply(temp, temp), a);
        }
        return multiply(temp, temp);
    }

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] += (A[i][k] * B[k][j]) % 1000;
                }
                C[i][j] %= 1000;
            }
        }
        return C;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[][] A = new long[8][8];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] result = new long[N][N];
        result = recursive(A, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}