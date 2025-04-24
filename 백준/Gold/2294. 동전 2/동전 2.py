import sys
input = sys.stdin.readline
# n은 동전의 개수, k는 만들어야 하는 값
n, k = map(int, input().split())
coin_list = []
for _ in range(n):
    coin = int(input())
    coin_list.append(coin)
# k의 최댓값인 10000보다 큰 수로 dp 배열 저장
# dp[i]는 금액 i를 만들기 위한 최소 동전 개수
dp = [10001] * (k+1)
# 0원을 만들기 위해 필요한 동전 수는 0개
dp[0] = 0

for coin in coin_list:
    for i in range(coin, k+1):
        # dp[i-coin]+1은 i-coin원을 만들고 coin을 하나 더 사용한 경우
        # dp[5-5]는 dp[0]원을 만들었을 때 코인이 0개 필요했고
        # dp[5]를 만들 때는 0원을 만들었을 때보다 코인이 1개 더 사용되므로 +1
        dp[i] = min(dp[i], dp[i-coin] + 1)

# 만들 수 없는 경우 -1을 리턴하고 만들 수 있다면 최소 동전 개수 출력
if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])