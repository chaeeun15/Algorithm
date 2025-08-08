import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n은 듣지 못한 사람의 수
        int n = Integer.parseInt(st.nextToken());
        // m은 보지 못한 사람의 수
        int m = Integer.parseInt(st.nextToken());

        String[] listen = new String[n];
        Set<String> see = new HashSet<>();

        for (int i = 0; i < n; i++) {
            listen[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            see.add(br.readLine());
        }

        int count = 0;
        List<String> listenSee = new ArrayList<>();
        for (String p : listen) {
            if (see.contains(p)) {
                count++;
                listenSee.add(p);
            }
        }

        Collections.sort(listenSee);
        StringBuilder sb = new StringBuilder();
        for (String p : listenSee) {
            sb.append(p).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
