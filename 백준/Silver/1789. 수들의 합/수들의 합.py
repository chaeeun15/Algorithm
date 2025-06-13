import sys
input = sys.stdin.readline

s = int(input())

low = 1
high = s
ans = 0

while low <= high:
    mid = (low + high) // 2
    temp = (mid + 1) * mid // 2
    if temp <= s:
        ans = mid
        low = mid + 1
    else:
        high = mid - 1
print(ans)