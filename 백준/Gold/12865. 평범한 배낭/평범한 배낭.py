import sys
input = sys.stdin.readline

# n은 물품의 수, k는 준서가 버틸 수 있는 무게
n, k = map(int, input().split())

weight = [0] * (n + 1)
value = [0] * (n + 1)
for i in range(n):
    weight[i + 1], value[i + 1] = map(int, input().split())

dp = [[0] * (k + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, k + 1):
        if j >= weight[i]:
            dp[i][j] = max(value[i] + dp[i - 1][j - weight[i]], dp[i - 1][j])
        else:
            dp[i][j] = dp[i - 1][j]
print(dp[n][-1])