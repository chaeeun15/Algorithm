import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int col = 0;
        if (H % (N + 1) == 0) {
            col = H / (N + 1);
        } else {
            col = H / (N + 1) + 1;
        }

        int row = 0;
        if (W % (M + 1) == 0) {
            row = W / (M + 1);
        } else {
            row = W / (M + 1) + 1;
        }

        System.out.println(col * row);
    }
}
