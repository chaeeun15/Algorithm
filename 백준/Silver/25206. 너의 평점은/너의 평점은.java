import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<String, Double> hashmap = new HashMap<>();
        hashmap.put("A+", 4.5);
        hashmap.put("A0", 4.0);
        hashmap.put("B+", 3.5);
        hashmap.put("B0", 3.0);
        hashmap.put("C+", 2.5);
        hashmap.put("C0", 2.0);
        hashmap.put("D+", 1.5);
        hashmap.put("D0", 1.0);
        hashmap.put("F", 0.0);
        Scanner scanner = new Scanner(System.in);
        Double total = 0.0d;
        Double num = 0.0d;
        for (int i = 0; i < 20; i++) {
            String input = scanner.nextLine();
            String[] input_arr = input.split(" ");
            if (!(input_arr[2].equals("P"))) {
                total += Double.parseDouble(input_arr[1]) * hashmap.get(input_arr[2]);
                num += Double.parseDouble(input_arr[1]);
            }
        }
        System.out.println(total/num);
    }
}