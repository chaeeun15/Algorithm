import java.util.*;

public class Main {
    static class Pair {
        int num;
        int index;
        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Pair> arr = new ArrayList<>();
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(scanner.nextInt(), i));
        }

        Collections.sort(arr, (a1, a2) -> Integer.compare(a1.num, a2.num));
        int countRank = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr.get(i).num != arr.get(i-1).num) {
                countRank++;
            }
            rank[arr.get(i).index] = countRank;
        }

        StringBuilder sb = new StringBuilder();
        for (int r : rank) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}