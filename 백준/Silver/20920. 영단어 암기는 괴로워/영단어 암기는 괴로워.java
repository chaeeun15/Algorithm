import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // n은 지문에 나오는 단어 개수
        int n = Integer.parseInt(st.nextToken());
        // m 보다 긴 단어만 외움
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(
            Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
            .thenComparing(e -> e.getKey().length(), Comparator.reverseOrder())
            .thenComparing(Map.Entry::getKey)
        );

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry: list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}