import sys
input = sys.stdin.readline

# 게임 판의 크기 n X n
n = int(input())
game = []
for _ in range(n):
    game.append(list(map(int, input().split())))

dp = [[0] * n for _ in range(n)]
dp[0][0] = 1
for i in range(n):
    for j in range(n):
        if game[i][j] == 0 or dp[i][j] == 0:
            continue
        if i + game[i][j] < n:
            dp[i + game[i][j]][j] += dp[i][j]
        if j + game[i][j] < n:
            dp[i][j + game[i][j]] += dp[i][j]
print(dp[n - 1][n - 1])