import sys
input = sys.stdin.readline

# n은 버튼 누르는 횟수
n = int(input())

dp = [i for i in range(n + 1)]

for i in range(1, n + 1):
    for j in range(3, i):
        dp[i] = max(dp[i], dp[i - j] * (j - 1))
print(dp[n])