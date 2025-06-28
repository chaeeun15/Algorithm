import sys
from collections import deque
input = sys.stdin.readline

# a -> b
a, b = map(int, input().split())

queue = deque()
queue.append((a, 1))

answer = -1
while queue:
    cur, cnt = queue.popleft()
    if cur == b:
        answer = cnt
        break
    if cur * 2 <= b:
        queue.append((cur * 2, cnt + 1))
    if int(str(cur) + '1') <= b:
        queue.append((int(str(cur) + '1'), cnt + 1))

print(answer)