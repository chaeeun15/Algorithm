import sys
input = sys.stdin.readline

# n일간 상담
n = int(input())

schedule = []
for _ in range(n):
    schedule.append(list(map(int, input().split())))

dp = [0] * (n + 1)
for i, s in enumerate(schedule):
    # t는 상담을 하는데 걸리는 날짜, p는 상담을 했을 때 얻을 수 있는 금액
    t, p = s[0], s[1]
    # 금액을 받지 않는 날도 업데이트를 해줘야 함
    # i+1일이 될 수 있는 경우가 여러 개 있을 수 있으므로 max로 업데이트
    dp[i + 1] = max(dp[i], dp[i + 1])
    # n일 안에 끝나는 경우만 추가해줌
    if i + t <= n:
        # 예를 들어 5일 상담이 2일 걸리고 15원을 받는 경우
        # 4일까지의 금액에 15를 더한 값이 dp[i] + p
        dp[i + t] = max(dp[i + t], dp[i] + p)
print(max(dp))