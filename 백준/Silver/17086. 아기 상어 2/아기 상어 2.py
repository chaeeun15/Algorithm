import sys
from collections import deque
input = sys.stdin.readline

# n x m 크기의 공간
n, m = map(int, input().split())
space = []
for _ in range(n):
    space.append(list(map(int, input().split())))

def bfs(i, j):
    visit = [[0] * m for _ in range(n)]
    dx = [1, 0, -1, 0, 1, -1, 1, -1]
    dy = [-1, 1, 1, -1, 0, 0, 1, -1]
    queue = deque()
    queue.append((i, j, 0))
    while queue:
        x, y, distance = queue.popleft()
        if space[x][y] == 1:
            return distance
        for i in range(8):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x <n and 0 <= next_y < m and visit[next_x][next_y] == 0:
                queue.append((next_x, next_y, distance + 1))
                visit[next_x][next_y] = 1

safe_distance = []
for i in range(n):
    for j in range(m):
        if space[i][j] == 0:
            safe_distance.append(bfs(i, j))
print(max(safe_distance))