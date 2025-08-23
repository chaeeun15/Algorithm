import java.io.*;
import java.util.*;
public class Main {
    static long[] histogram;

    static long recursive(int start, int end) {
        if (start == end) {
            return histogram[start];
        }
        int mid = (start + end) / 2;
        long leftSquare = recursive(start, mid);
        long rightSquare = recursive(mid + 1, end);
        long max = Math.max(leftSquare, rightSquare);
        max = Math.max(max, midArea(start, end, mid));
        return max;
    }

    static long midArea(int start, int end, int mid) {
        int toLeft = mid;
        int toRight = mid;
        long height = histogram[mid];
        long maxArea = height;
        while (start < toLeft && toRight < end) {
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]);
                maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
            } else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
                maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
            }
        }

        while (start < toLeft) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < end) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        
        return maxArea;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            histogram = new long[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(recursive(0, n - 1)).append("\n");
            histogram = null;
        }
        System.out.println(sb);
    }
}