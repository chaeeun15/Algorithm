import sys
input = sys.stdin.readline

dp = [0] * 5001
dp[0] = 1
# 홀수인 경우 무조건 0이므로 짝수만 계산
for n in range(2, 5001, 2):
    # (A)B 형태로 나눔 -> A는 dp[i-2], B는 dp[n-i]
    # A의 크기를 0에서 점점 키워가면서 개수 더해감
    for i in range(2, n + 1, 2):
        dp[n] += dp[i - 2] * dp[n - i]
    dp[n] %= 1000000007

# t는 테스트 케이스의 개수
t = int(input())
for _ in range(t):
    # l은 괄호 문자열의 길이
    l = int(input())
    print(dp[l])