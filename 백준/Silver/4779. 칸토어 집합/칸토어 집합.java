import java.io.*;
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static String recursive(int n) {
        if (n == 1) {
            return "-";
        }
        return recursive(n/3) + " ".repeat(n/3) + recursive(n/3);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);
            sb.append(recursive((int) Math.pow(3, n))).append("\n");
        }
        System.out.println(sb);
    }
}