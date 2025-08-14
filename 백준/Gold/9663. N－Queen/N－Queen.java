import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int cnt = 0;

    // chess 재귀함수는 전체 체스판에서 왼쪽에서 오른쪽으로 이동하는 의미
    // depth == n이라는 건 제일 오른쪽에 도착했다는 뜻
    public static void chess(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        // 여기 for문은 한 열의 제일 위에서부터 시작해서 아래로 내려가는 의미
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            // 현재 행의 위치가 놓을 수 있는 자리면 다음 열로 이동
            if (check(depth)) {
                chess(depth + 1);
            }
        }
    }

    public static boolean check(int col) {
        // 현재 열보다 왼쪽에 있는 열들이랑 비교
        for (int i = 0; i < col; i++) {
            // 왼쪽에 있는 열 중 지금 퀸을 놓으려는 위치랑 같은 행에 이미 퀸이 있으면
            if (arr[col] == arr[i]) {
                return false;
            }
            // 지금 퀸의 놓으려는 위치의 대각선 위치에 이미 퀸이 있으면
            else if (Math.abs(i - col) == Math.abs(arr[i] - arr[col])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        chess(0);
        System.out.println(cnt);
    }
}
