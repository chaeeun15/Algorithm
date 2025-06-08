import sys
input = sys.stdin.readline

n = int(input())
answer = 0
num_list = list(map(int, input().split()))

for num in num_list:
    if num > 1:
        for i in range(2, int(num**(1/2)) + 1):
            if num%i == 0:
                break
        else:
            answer += 1
print(answer)