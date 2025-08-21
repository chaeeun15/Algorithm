import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "+" + br.readLine();

        long result = 0;
        StringBuilder sb_plus;
        StringBuilder sb_minus;
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '-') {
                i++;
                sb_minus = new StringBuilder();
                int temp = 0;
                while (i < input.length() && input.charAt(i) != '-') {
                    if (input.charAt(i) == '+') {
                        temp += Integer.parseInt(sb_minus.toString());
                        sb_minus = new StringBuilder();
                    } else {
                        sb_minus.append(input.charAt(i));
                    }
                    i++;
                }
                temp += Integer.parseInt(sb_minus.toString());
                result -= temp;
            } else if (input.charAt(i) == '+') {
                i++;
                sb_plus = new StringBuilder();
                while (i < input.length() && !(input.charAt(i) == '+' || input.charAt(i) == '-')) {
                    sb_plus.append(input.charAt(i));
                    i++;
                }
                result += Integer.parseInt(sb_plus.toString());
            }
        }
        System.out.println(result);
    }
}