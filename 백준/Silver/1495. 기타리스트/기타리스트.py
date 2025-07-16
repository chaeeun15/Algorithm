import sys
input = sys.stdin.readline

# n은 곡의 개수, s는 시작 볼륨, m은 볼륨의 최댓값
n, s, m = map(int, input().split())
# v는 볼륨 변화 리스트
v = list(map(int, input().split()))

# 곡 n개가 각자 볼륨 m만큼의 리스트를 가지고 있는 것
# n번째 곡일 때 가능한 볼륨이 있으면 1로 표시함
dp = [[0] * (m + 1) for _ in range(n + 1)]
dp[0][s] = 1

for i in range(n):
    for j in range(m + 1):
        if dp[i][j] == 1:
            if 0 <= j + v[i] <= m:
                dp[i + 1][j + v[i]] = 1
            if 0 <= j - v[i] <= m:
                dp[i + 1][j - v[i]] = 1

for i in range(m, -1, -1):
    if dp[n][i] == 1:
        print(i)
        break
    if i == 0:
        print(-1)