import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer[]> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Integer[i + 1]);
            for (int j = 0; j < i + 1; j++) {
                list.get(i)[j] = Integer.parseInt(st.nextToken());
            }
        }
        
        ArrayList<Integer[]> dp = new ArrayList<>();
        dp.add(list.get(0));
        for (int i = 1; i < n; i++) {
            dp.add(new Integer[i + 1]);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp.get(i)[j] = dp.get(i - 1)[j] + list.get(i)[0];
                } else if (j == i) {
                    dp.get(i)[j] = dp.get(i - 1)[j - 1] + list.get(i)[j];
                } else {
                    dp.get(i)[j] = Math.max(dp.get(i - 1)[j - 1], dp.get(i - 1)[j]) + list.get(i)[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp.get(n - 1)[i]);
        }
        System.out.println(ans);
    }
}