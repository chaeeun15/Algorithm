import sys
input = sys.stdin.readline

# n은 보도블록 개수
n = int(input())
road = str(input().strip())
dp = [10e9] * n
dp[0] = 0

seq = ['B', 'O', 'J']
for i in range(len(road)):
    for j in range(i):
        if (seq.index(road[i])) % 3 == (seq.index(road[j]) + 1) % 3:
            dp[i] = min(dp[i], dp[j] + (i - j)**2)
print(dp[n - 1]) if dp[n - 1] != 10e9 else print(-1)