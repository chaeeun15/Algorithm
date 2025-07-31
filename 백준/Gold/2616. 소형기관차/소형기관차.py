import sys
input = sys.stdin.readline

# n은 객차의 총 개수
n = int(input())
# arr에는 각 객차에 타고 있는 사람의 수가 저장됨
arr = list(map(int, input().split()))
# k는 소형 기관차가 최대로 끌 수 있는 객차의 수
k = int(input())

dp = [[0] * (n + 1) for _ in range(4)]

prefix_sum = [0]
for i in range(1, n+1):
    # 객차는 연속되어야 하기 때문에 부분합 사용
    prefix_sum.append(prefix_sum[i - 1] + arr[i - 1])

for i in range(1, 4):
    for j in range(k, n + 1):
        # prefix_sum[j] - prefix_sum[j - k]는 j-k+1번째부터 j번째 객차까지 탄 사람의 수의 합
        # dp[i][j]는 소형 기관차를 i개 사용했을 때 j번째 객차까지 사용한 경우 운송할 수 있는 손님 수의 최댓값
        # 예를 들어 dp[2][3]은 소형 기관차를 2개 사용하고 3번째 객차까지 사용한 경우
        # 소형 기관차 한 개는 하나의 객차만을 끌 수 있어서 의미 없어짐 -> dp[1][1] + 2번~3번 객차에 탄 사람 수의 합
        # -> 0 + 90 = 90
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - k] + prefix_sum[j] - prefix_sum[j - k])
print(dp[3][-1])