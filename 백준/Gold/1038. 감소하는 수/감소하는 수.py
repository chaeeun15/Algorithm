import sys
from collections import deque
input = sys.stdin.readline

# n번째 감소하는 수 구하기
n = int(input())
queue = deque()
for i in range(10):
    queue.append(str(i))

reduce_num = []
while queue:
    cur = queue.popleft()
    reduce_num.append(int(cur))
    # 맨 마지막 숫자가 0이 아닌 경우
    # 그 숫자보다 작은 숫자를 뒤에 붙여서 새로운 수 만들기
    if cur[-1] != '0':
        for i in range(1, int(cur[-1]) + 1):
            next = cur + str(int(cur[-1]) - i)
            queue.append(next)

reduce_num.sort()
if n >= len(reduce_num):
    print(-1)
else:
    print(reduce_num[n])