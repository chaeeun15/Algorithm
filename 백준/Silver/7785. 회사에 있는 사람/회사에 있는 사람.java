import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        HashMap<String, String> hm = new HashMap<>();
        String key;
        String value;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            key = st.nextToken();
            value = st.nextToken();
            if (value.equals("enter")) {
                hm.put(key, value);
            } else if (value.equals("leave")) {
                hm.remove(key);
            }
        }

        List<Map.Entry<String, String>> list = new LinkedList<>(hm.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getKey().compareTo(e1.getKey()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry: list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}