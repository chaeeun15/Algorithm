import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    static void comb(int idx, int num) {
        // n/2명만 visit을 true로 바꾼 뒤 diff() 실행
        if (num == n / 2) {
            diff();
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(i + 1, num + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                } else if (!visit[i] && !visit[j]) {
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int abs = Math.abs(team_start - team_link);
        if (abs == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, abs);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n];
        comb(0, 0);
        System.out.println(min);
    }
}