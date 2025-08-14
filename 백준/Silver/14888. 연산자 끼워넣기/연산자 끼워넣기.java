import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int[] arr;
    public static int[] op;
    public static int max = -1000000001;
    public static int min = 1000000001;
    
    public static void dfs(int depth, int cur, int plus, int minus, int mult, int div) {
        if (depth == n) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        if (plus < op[0]) {
            dfs(depth + 1, cur + arr[depth], plus + 1, minus, mult, div);
        }
        if (minus < op[1]) {
            dfs(depth + 1, cur - arr[depth], plus, minus + 1, mult, div);
        }
        if (mult < op[2]) {
            dfs(depth + 1, cur * arr[depth], plus, minus, mult + 1, div);
        }
        if (div < op[3]) {
            if (cur > 0) {
                dfs(depth + 1, cur / arr[depth], plus, minus, mult, div + 1);
            } else {
                dfs(depth + 1, (cur*(-1) / arr[depth]) * (-1), plus, minus, mult, div + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0], 0, 0, 0, 0);
        System.out.println(max);
        System.out.println(min);
    }
}