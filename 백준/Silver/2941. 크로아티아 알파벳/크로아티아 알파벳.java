import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int answer = 0;
        int i = 0;
        while (i < input.length()) {
            if (i < input.length()-2 && set.contains(input.substring(i, i+3))) {
                i += 3;
            } else if (i < input.length()-1 && set.contains(input.substring(i, i+2))) {
                i += 2;
            } else {
                i += 1;
            }
            answer++;
        }
        System.out.println(answer);
    }
}