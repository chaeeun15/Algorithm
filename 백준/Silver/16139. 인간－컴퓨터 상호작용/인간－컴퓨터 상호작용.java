import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] sum = new int[s.length() + 1][26];
        for (int i = 1; i < s.length() + 1; i++) {
            int num = s.charAt(i - 1) - 97;
            for (int j = 0; j < 26; j++) {
                if (j == num) {
                    sum[i][j] = sum[i - 1][j] + 1;
                } else {
                    sum[i][j] = sum[i - 1][j];
                }
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int alpha = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int temp = sum[r + 1][alpha] - sum[l][alpha];
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}