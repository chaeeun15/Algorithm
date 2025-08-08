import java.io.*;
import java.util.*;
public class Main {
    static class Pair {
        int age;
        String name;
    
        public Pair(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 온라인 저지 회원의 수
        int n = Integer.parseInt(br.readLine());

        List<Pair> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Pair(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list, (a1, a2) -> {
            if (a1.age == a2.age) {
                return 0;
            } else {
                return a1.age - a2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).age + " " + list.get(i).name).append('\n');
        }
        System.out.println(sb);
    }
}