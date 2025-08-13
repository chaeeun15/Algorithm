import java.io.*;
import java.util.*;
public class Main {
    public static int cnt = 0;
    public static List<Integer> arr;
    public static StringBuilder sb = new StringBuilder();

    public static void merge_sort(List<Integer> arr, int p, int r, int k) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q, k);
            merge_sort(arr, q + 1, r, k);
            merge(arr, p, q, r, k);
        }
    }

    public static void merge(List<Integer> arr, int p, int q, int r, int k) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr.get(i) <= arr.get(j)) {
                tmp[t++] = arr.get(i++);
            } else {
                tmp[t++] = arr.get(j++);
            }
        }
        while (i <= q) {
            tmp[t++] = arr.get(i++);
        }
        while (j <= r) {
            tmp[t++] = arr.get(j++);
        }
        i = p;
        t = 0;
        while (i <= r) {
            arr.set(i++, tmp[t]);
            cnt++;
            if (cnt == k) {
                sb.append(tmp[t]);
                break;
            }
            t++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n은 배열 A의 크기
        int n = Integer.parseInt(st.nextToken());
        // k는 저장 횟수
        int k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        merge_sort(arr, 0, n - 1, k);
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}