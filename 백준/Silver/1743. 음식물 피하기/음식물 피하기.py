import sys
from collections import deque
input = sys.stdin.readline

# n은 통로의 세로 길이, m은 가로 길이, k는 음식물 쓰레기의 개수
n, m, k = map(int, input().split())
maps = [[0] * m for _ in range(n)]

for _ in range(k):
    r, c = map(int, input().split())
    maps[r-1][c-1] = 1

visit = [[0] * m for _ in range(n)]
dr = [0, 1, -1, 0]
dc = [1, 0, 0, -1]
def bfs(r, c):
    queue = deque()
    queue.append((r, c))
    visit[r][c] = 1
    cnt = 0
    while queue:
        cur_r, cur_c = queue.popleft()
        cnt += 1
        for i in range(4):
            next_r = cur_r + dr[i]
            next_c = cur_c + dc[i]
            if 0 <= next_r < n and 0 <= next_c < m:
                if visit[next_r][next_c] == 0:
                    if maps[next_r][next_c] == 1:
                        queue.append((next_r, next_c))
                        visit[next_r][next_c] = 1
    return cnt

ans = 0
for i in range(n):
    for j in range(m):
        if visit[i][j] == 0 and maps[i][j] == 1:
            ans = max(ans, bfs(i, j))
print(ans)