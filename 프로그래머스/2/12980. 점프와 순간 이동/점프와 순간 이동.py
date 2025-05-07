def solution(n):
    ans = 0
    while n != 1:
        if n%2 != 0:
            ans += n%2
        n //= 2
    return ans + 1