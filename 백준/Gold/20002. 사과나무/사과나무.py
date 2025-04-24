# prefix sum을 사용해서 실행 시간을 줄일 수 있음.
import sys
input = sys.stdin.readline
N = int(input())
pre = [[-1001] * (N+1) for _ in range(N+1)]
for i in range(1, N+1):
    arr = list(map(int, input().split()))
    for j in range(1, N+1):
        # pre[i][j]는 (0, 0)부터 (i, j)까지 구간의 합
        pre[i][j] = pre[i][j-1] + pre[i-1][j]-pre[i-1][j-1] + arr[j-1]

answer = pre[0][0]
# K는 수확할 정사각형의 한 변의 길이
for K in range(N):
    for i in range(1, N-K+1):
        for j in range(1, N-K+1):
            cost = pre[i+K][j+K] - pre[i-1][j+K] - pre[i+K][j-1] + pre[i-1][j-1]
            answer = max(answer, cost)
print(answer)