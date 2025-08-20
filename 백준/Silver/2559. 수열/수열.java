import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[n - k + 1];
        int[] temperature = new int[n];
        
        int temp = 0;
        for (int i = 0; i < k - 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            temp += input;
            temperature[i] = input;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            temperature[i + k - 1] = input;
            temp += input;
            sum[i] = temp;
            max = Math.max(max, temp);
            temp -= temperature[i];
        }

        System.out.println(max);
    }
}