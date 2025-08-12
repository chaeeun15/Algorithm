import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int total = 0;
        int max = -4000;
        int min = 4000;
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            total += num;
            list.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            maxCnt = Math.max(maxCnt, map.get(num));
        }

        Collections.sort(list);

        List<Integer> maplist = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCnt) {
                maplist.add(entry.getKey());
            }
        }

        Collections.sort(maplist);

        System.out.println((int) Math.round((double) total / n));
        System.out.println(list.get(n / 2));
        if (maplist.size() > 1) {
            System.out.println(maplist.get(1));
        } else {
            System.out.println(maplist.get(0));
        }
        System.out.println(max - min);
    }
}