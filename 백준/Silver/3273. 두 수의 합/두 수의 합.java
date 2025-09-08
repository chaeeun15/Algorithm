import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int p1 = 0;
        int p2 = n - 1;
        Arrays.sort(arr);
        int ans = 0;
        while (p1 < p2) {
            if (arr[p1] + arr[p2] == x) {
                ans++;
                p1++;
            } else if (arr[p1] + arr[p2] < x) {
                p1++;
            } else {
                p2--;
            }
        }
        System.out.println(ans);
    }
}
