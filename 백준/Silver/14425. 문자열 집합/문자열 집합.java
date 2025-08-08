import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // n은 집합 S에 포함되어 있는 문자열의 개수
        int n = Integer.parseInt(st.nextToken());
        // m은 검사해야 하는 문자열의 개수
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        String[] arr = new String[m];
        for (int i = 0; i < m; i++) {
            arr[i] = br.readLine();
        }

        int answer = 0;
        for (String a : arr) {
            if (hs.contains(a)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}