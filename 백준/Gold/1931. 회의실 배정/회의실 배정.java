import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의가 끝나는 시간이 빠른 순서대로 정렬
        Arrays.sort(meeting, (m1, m2) -> (m1[1] == m2[1]) ? Integer.compare(m1[0], m2[0]) : Integer.compare(m1[1], m2[1]));
        int cnt = 0;
        int finished = 0;
        for (int i = 0; i < n; i++) {
            if (meeting[i][0] >= finished) {
                cnt++;
                finished = meeting[i][1];
            }
        }
        System.out.println(cnt);
    }
}