import sys
input = sys.stdin.readline

# t는 테스트 케이스의 개수
t = int(input())

dp = [0] * 10001
dp[0] = 1
for i in range(1, 4):
    for j in range(i, 10001):
        dp[j] = dp[j] + dp[j - i]

for _ in range(t):
    n = int(input())
    print(dp[n])