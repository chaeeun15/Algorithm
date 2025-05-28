# from math import comb
# def solution(n):
#     answer = 0
#     for i in range(n//2 + 1):
#         answer += comb(n-i, i)
#     return answer%1000000007
def solution(n):
    memo = [0] * (n+1)
    memo[0] = 1
    memo[1] = 1
    for i in range(2, n+1):
        memo[i] = (memo[i-1] + memo[i-2]) % 1000000007
    return memo[n]