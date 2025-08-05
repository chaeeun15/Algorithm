import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            Set<Character> set = new HashSet<>();
            char c = ' ';
            int temp = 0;
            for (char w: word.toCharArray()) {
                if (w != c && set.contains(w)) {
                    temp++;
                    break;
                }
                c = w;
                set.add(c);
            }
            if (temp == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
