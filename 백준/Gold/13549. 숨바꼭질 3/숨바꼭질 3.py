import sys
from collections import deque
input = sys.stdin.readline

# n은 수빈이의 위치, k는 동생의 위치
n, k = map(int, input().split())

queue = deque()
queue.append(n)
visit = [0] * 200001
min_time = 100001

while queue:
    cur = queue.popleft()
    if cur == k:
        min_time = min(visit[cur], min_time)
    if visit[cur] > min_time:
        break
    arr = [cur * 2, cur + 1, cur - 1]
    for a in arr:
        if 0 <= a <= 200000 and (visit[a] == 0 or visit[a] > visit[cur]):
            if a == (cur * 2):
                queue.append(a)
                visit[a] = visit[cur]
            else:
                queue.append(a)
                visit[a] = visit[cur] + 1
print(min_time)