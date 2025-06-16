import sys
from collections import deque
input = sys.stdin.readline

# n은 지도의 한 변의 길이
n = int(input())
map_list = []
for _ in range(n):
    map_list.append(list(map(int, input().strip())))

def bfs(x, y, visit):
    queue = deque()
    queue.append((x, y))
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    visit[x][y] = 1
    count = 0
    while queue:
        cur_x, cur_y = queue.popleft()
        count += 1
        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]
            if 0 <= next_x < n and 0 <= next_y < n:
                if visit[next_x][next_y] == 0 and map_list[next_x][next_y] == 1:
                    visit[next_x][next_y] = 1
                    queue.append((next_x, next_y))
    return count

answer = []
visit = [[0] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if map_list[i][j] == 1 and visit[i][j] == 0:
            answer.append(bfs(i, j, visit))
answer.sort()
print(len(answer))
for i in range(len(answer)):
    print(answer[i])