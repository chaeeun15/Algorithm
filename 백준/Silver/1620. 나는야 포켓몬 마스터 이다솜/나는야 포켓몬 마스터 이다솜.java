import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n은 도감에 수록되어 있는 포케몬의 개수
        int n = Integer.parseInt(st.nextToken());
        // m은 맞춰야 하는 문제의 개수
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map_int = new HashMap<>();
        HashMap<String, Integer> map_string = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map_int.put(i+1, input);
            map_string.put(input, i+1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (input.chars().allMatch(Character::isDigit)) {
                sb.append(map_int.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(map_string.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}