import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        Integer[] arr = new Integer[n.length()];
        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int num : arr) {
            System.out.print(num);
        }
    }
}