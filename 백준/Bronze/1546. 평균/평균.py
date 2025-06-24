import sys
input = sys.stdin.readline

# n은 시험 본 과목의 개수
n = int(input())
score = list(map(int, input().split()))
max_score = max(score)

total = 0
for i in range(n):
    score[i] = score[i] / max_score * 100
    total += score[i]

print(total / n)