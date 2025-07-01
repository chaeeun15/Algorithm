import sys
from collections import deque
input = sys.stdin.readline

# n은 수빈이의 위치, k는 동생의 위치
n, k = map(int, input().split())

queue = deque()
queue.append((n, 0))

visit = [0] * 200001
min_time = 100001
cnt = 0
while queue:
    cur, time = queue.popleft()
    if cur == k:
        min_time = time
        cnt += 1
    if min_time < time:
        break
    arr = [cur + 1, cur - 1, cur * 2]
    for a in arr:
        if 0 <= a <= 200000 and (visit[a] == 0 or visit[a] == visit[cur] + 1):
            queue.append((a, time + 1))
            visit[a] = visit[cur] + 1

print(min_time)
print(cnt)