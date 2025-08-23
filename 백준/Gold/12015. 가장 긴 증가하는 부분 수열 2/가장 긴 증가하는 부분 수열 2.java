import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[n];
        LIS[0] = A[0];
        int LIS_length = 0;
        for (int i = 1; i < n; i++) {
            // 새로운 값이 LIS의 마지막 값보다 크면 그냥 추가
            if (LIS[LIS_length] < A[i]) {
                LIS_length++;
                LIS[LIS_length] = A[i];
            } else {
                // LIS에서 새로운 값보다 크면서 최소인 값의 위치 찾기 -> lower bound
                int start = 0;
                int end = LIS_length + 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (LIS[mid] < A[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                LIS[start] = A[i];
            }
        }
        System.out.println(LIS_length + 1);
    }
}
