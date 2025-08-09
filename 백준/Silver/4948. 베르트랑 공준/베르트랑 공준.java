import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num;
        StringBuilder sb = new StringBuilder();
        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            int count = 0;
            for (int i = num + 1; i < num * 2 + 1; i++) {
                int temp = 0;
                for (int j = 2; j < ((int) Math.sqrt(i)) + 1; j++) {
                    if (i % j == 0) {
                        temp++;
                        break;
                    }
                }
                if (temp == 0 && i != 1) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}