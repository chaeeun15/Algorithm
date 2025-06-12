import sys
input = sys.stdin.readline

# p가 s의 부분 문자열이면 1, 아니면 0 출력
s = input().strip()
p = input().strip()

# pi 리스트
pi = [0] * len(p)
i = 0
for j in range(1, len(p)):
    while i > 0 and p[i] != p[j]:
        i = pi[i-1]
    if p[i] == p[j]:
        i += 1
        pi[j] = i

# kmp 알고리즘
i = 0
for j in range(len(s)):
    while i > 0 and p[i] != s[j]:
        i = pi[i-1]
    if p[i] == s[j]:
        i += 1
        if i == len(p):
            print(1)
            break
else:
    print(0)