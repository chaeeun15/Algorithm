import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int index = k - 1;
        while (!(list.isEmpty())) {
            index %= list.size();
            if (list.size() != 1) {
                sb.append(list.get(index)).append(", ");
            } else {
                sb.append(list.get(index)).append(">");
            }
            list.remove(index);
            index += (k - 1);
        }
        System.out.println(sb);
    }
}