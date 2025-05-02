def solution(n):
    memo = {0: 0, 1: 1}
    num = 0
    for i in range(1, n):
        if i in memo:
            memo[i+1] = memo[i] + memo[i-1]
    return memo[n]%1234567

