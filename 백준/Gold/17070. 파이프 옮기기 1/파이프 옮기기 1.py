import sys
from collections import deque
input = sys.stdin.readline

# n은 집의 크기 (3 <= n <= 16)
n = int(input())
# 0은 빈 칸, 1은 벽
house = []
for _ in range(n):
    house.append(list(map(int, input().split())))

# dp[3][n][n] 형태. 첫 번째 값은 파이프의 방향(0 가로, 1 세로, 2 대각선)
dp = [[[0 for _ in range(n)] for _ in range(n)] for _ in range(3)]

# 첫 번째 열은 이동할 수 없으므로 dp값이 다 초기값인 0이 됨.
# 첫 번째 행은 가로로 밀어서만 이동할 수 있으므로 dp 값을 다 1로 설정.
for i in range(1, n):
    # 벽이 있는 경우 더 이상 이동할 수 없음.
    if house[0][i] == 1:
        break
    dp[0][0][i] = 1

for i in range(1, n):
    for j in range(1, n):
        # 이동한 뒤 차지하는 공간에 벽이 없어야 함.
        if house[i][j] == 0 and house[i-1][j] == 0 and house[i][j-1] == 0:
            # 파이프가 대각선으로 놓이는 경우는 가로, 세로, 대각선 3가지
            dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]
        if house[i][j] == 0:
            # 파이프가 가로로 놓이는 경우는 가로, 대각선 2가지
            dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1]
            # 파이프가 세로로 놓이는 경우는 세로, 대각선 2가지
            dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j]
print(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1])