import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if (set.contains(input.substring(i, i + j + 1))) {
                    continue;
                } else {
                    set.add(input.substring(i, i + j + 1));
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}