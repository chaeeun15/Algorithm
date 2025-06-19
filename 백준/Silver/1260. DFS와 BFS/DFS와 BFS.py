import sys
from collections import deque
input = sys.stdin.readline

# n은 정점의 개수, m은 간선의 개수, v는 탐색을 시작할 정점
n, m, v = map(int, input().split())
graph = [[] for i in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 정점 번호가 작은 것을 먼저 방문하기 위해
for line in graph:
    line.sort()

# dfs
visit_dfs = [0 for _ in range(n+1)]
def dfs(v):
    visit_dfs[v] = 1
    print(v, end = ' ')
    for next_v in graph[v]:
        if visit_dfs[next_v] == 0:
            dfs(next_v)
dfs(v)
print()

# bfs
visit_bfs = [0 for _ in range(n+1)]
def bfs(v):
    queue = deque()
    queue.append(v)
    visit_bfs[v] = 1
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for next_v in graph[v]:
            if visit_bfs[next_v] == 0:
                queue.append(next_v)
                visit_bfs[next_v] = 1
bfs(v)