import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // test는 테스트 케이스의 개수
        int test = Integer.parseInt(br.readLine());
        long num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) { 
            num = Long.parseLong(br.readLine());
            while (true) {
                if (num == 0 || num == 1) {
                    num = 2;
                }
                int temp = 0;
                for (int j = 2; j < ((int) Math.sqrt(num)) + 1; j++) {
                    if (num % j == 0) {
                        temp++;
                        break;
                    }
                }
                if (temp == 0) {
                    sb.append(num).append("\n");
                    break;
                }
                num++;
            }
        }
        System.out.println(sb);
    }
}