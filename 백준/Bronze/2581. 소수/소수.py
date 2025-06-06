import sys
input = sys.stdin.readline

m = int(input())
n = int(input())
total = 0
first = 0

for num in range(m, n+1):
    if num > 1:
        for i in range(2, int(num**(1/2))+1):
            if num % i == 0:
                break
        else:
            if total == 0:
                first = num
            total += num

if total == 0:
    print(-1)
else:
    print(total)
    print(first)