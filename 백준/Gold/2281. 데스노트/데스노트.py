import sys
input = sys.stdin.readline

# n은 사람의 수, m은 노트의 가로 길이
n, m = map(int, input().split())
people = []
for _ in range(n):
    people.append(int(input()))

# dp의 칸의 개수만큼을 max_value로 설정
max_value = n * m * m
dp = [[max_value] * (m + 1) for _ in range(n)]
# 맨 마지막 줄은 계산에 더해지지 않음
# 현재는 첫 줄이 마지막 줄이기 때문에 dp값을 0으로 설정함
# ex) dp[2]는 3번째 이름까지 적었을 때 남은 공간의 제곱의 합들을 적어둔 것
dp[0][people[0]] = 0

for i in range(n - 1):
    for j in range(1, m + 1):
        if dp[i][j] != max_value:
            # 바로 뒤에 붙이는 경우
            if j + 1 + people[i + 1] <= m: # +1은 두 단어 사이의 빈 칸
                # 바로 뒤에 붙이는 경우에는 여전히 마지막 줄은 합에 포함되지 않으므로
                # 위치만 j + 1 + people[i + 1]번째 칸으로 바뀌고 dp 값은 유지됨
                dp[i + 1][j + 1 + people[i + 1]] = dp[i][j]
            # 다음 줄로 넘어가는 경우 이전 줄의 남은 공간이 제곱의 합에 포함되어야 함
            dp[i + 1][people[i + 1]] = min(dp[i + 1][people[i + 1]], dp[i][j] + (m - j)**2)
print(min(dp[n-1]))