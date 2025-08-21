import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] road = new long[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        long[] price = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long total = 0L;
        long pre = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (pre <= price[i]) {
                total += pre * road[i];
            } else {
                total += price[i] * road[i];
                pre = price[i];
            }
        }
        System.out.println(total);
    }
}