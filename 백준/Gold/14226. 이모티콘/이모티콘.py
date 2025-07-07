import sys
from collections import deque
input = sys.stdin.readline

# s는 만들어야 할 이모티콘의 개수
s = int(input())

queue = deque()
# (화면에 존재하는 이모티콘 수, 클립보드에 복사된 이모티콘 수수)
queue.append((1, 0))
# 1001은 클립보드에 저장될 수 있는 이모티콘 최댓값
# 2001은 화면에 존재할 수 있는 이모티콘 최댓값
visit = [[0] * 1001 for _ in range(2001)]

while queue:
    cur, clipboard = queue.popleft()
    if cur == s:
        print(visit[cur][clipboard])
        break
    arr = [
        (cur, cur),
        (cur + clipboard, clipboard),
        (cur - 1, clipboard)
    ]
    for next, next_clip in arr:
        if 0 <= next <= 2000 and 0 <= next_clip <= 1000 and visit[next][next_clip] == 0:
            queue.append((next, next_clip))
            visit[next][next_clip] = visit[cur][clipboard] + 1