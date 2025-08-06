import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int temp = 0;
        int i = 1;
        int pre = 0;
        // i는 분모, 분자를 더한 값
        // x - pre는 해당 그룹 안에서의 위치
        while (temp < x) {
            temp += i;
            i++;
            if (temp < x) {
                pre = temp;
            }
        }
        // i가 짝수이면 분자는 점점 작아지고 분모는 점점 커짐
        if (i % 2 == 0) {
            int numerator = i - 1;
            int denominator = 1;
            for (int j = 0; j < (x - pre - 1); j++) {
                numerator--;
                denominator++;
            }
            System.out.println(numerator + "/" + denominator);
        } else { // i가 홀수이면 분자는 점점 커지고 분모는 점점 작아짐
            int numerator = 1;
            int denominator = i - 1;
            for (int j = 0; j < (x - pre - 1); j++) {
                numerator++;
                denominator--;
            }
            System.out.println(numerator + "/" + denominator);
        }
    }
}