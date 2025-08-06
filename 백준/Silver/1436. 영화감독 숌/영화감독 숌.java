import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 0;
        int i = 0;
        String temp = "";
        while (i < n) {
            temp = Integer.toString(num) + "666";
            int temp_num = 0;
            // 6이 4번 이상 반복되면
            if (temp.contains("6666")) {
                // 666을 한 칸씩 앞으로 옮긴 다음 뒤를 0으로 채움
                temp_num = Integer.parseInt(temp.substring(0, temp.indexOf("666")) + "666" + "0".repeat(temp.length() - 3 - temp.indexOf("666")));
                i++;
                if (i >= n) {
                    temp = Integer.toString(temp_num);
                    break;
                }
                // 666 연속이 사라지면 while문 종료
                while (Integer.toString(++temp_num).contains("666")) {
                    i++;
                    if (i >= n) {
                        break;
                    }
                }
            }
            num++;
            if (temp_num == 0) {
                i++;
            } else {
                temp = Integer.toString(temp_num);
            }
        }
        System.out.println(Integer.parseInt(temp));
    }
}