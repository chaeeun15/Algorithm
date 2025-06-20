import sys
from collections import deque
input = sys.stdin.readline

# n은 전쟁터의 가로 크기, m은 세로 크기
n, m = map(int, input().split())
war = []
for _ in range(m):
    war.append(input().strip())

visit = [[0] * n for _ in range(m)]

def dfs(i, j):
    queue = deque()
    queue.append((i, j))
    cnt = 0

    dr = [0, 1, 0, -1]
    dc = [1, 0, -1, 0]
    visit[i][j] = 1
    while queue:
        curr, curc = queue.popleft()
        cnt += 1
        for i in range(4):
            nextr = curr + dr[i]
            nextc = curc + dc[i]
            if 0 <= nextr < m and 0 <= nextc < n:
                if visit[nextr][nextc] == 0 and war[nextr][nextc] == war[curr][curc]:
                    queue.append((nextr, nextc))
                    visit[nextr][nextc] = 1
    return cnt*cnt

cnt_blue = 0
cnt_white = 0
for i in range(m):
    for j in range(n):
        if visit[i][j] == 0:
            if war[i][j] == 'B':
                cnt_blue += dfs(i, j)
            else:
                cnt_white += dfs(i, j)
print(cnt_white, cnt_blue)