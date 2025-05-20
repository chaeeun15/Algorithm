import sys
input = sys.stdin.readline

# n은 온라인 저지 회원의 수
n = int(input())
people = []
for _ in range(n):
    people.append(list(input().split()))
people.sort(key = lambda x: int(x[0]))

for i in range(n):
    print(int(people[i][0]), people[i][1])