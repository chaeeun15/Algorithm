import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        // Arrays.sort()를 쓰면 시간 초과가 뜸.
        Collections.sort(arr);
        for (int num: arr) {
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }
}