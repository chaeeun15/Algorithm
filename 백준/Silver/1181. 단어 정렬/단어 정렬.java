import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 단어의 개수
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                for (int j = 0; j < s1.length(); j++) {
                    if (s1.charAt(j) != s2.charAt(j)) {
                        return s1.charAt(j) - s2.charAt(j);
                    }
                }
                return 0;
            } else {
                return s1.length() - s2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        String pre = "";
        for (String a : arr) {
            if (!(a.equals(pre))) {
                sb.append(a).append('\n');
            }
            pre = a;
        }
        System.out.println(sb);
    }
}