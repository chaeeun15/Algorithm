import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // a는 A의 원소의 개수
        int a = Integer.parseInt(st.nextToken());
        // b는 B의 원소의 개수
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        int setASize = setA.size();

        Set<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }
        int setBSize = setB.size();

        setA.retainAll(setB);
        int retainNum = setA.size(); // 두 집합의 교집합의 원소의 개수
        System.out.println(setASize + setBSize - (2 * retainNum));

    }
}