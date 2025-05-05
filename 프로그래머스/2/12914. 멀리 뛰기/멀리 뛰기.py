memo = {1: 1, 2: 2}
def solution(n):
    answer = 0
    for i in range(1, n+1):
        if i not in memo:
            memo[i] = memo[i-2] + memo[i-1]
    return memo[n] % 1234567