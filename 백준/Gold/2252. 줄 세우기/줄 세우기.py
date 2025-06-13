import sys
from collections import deque
input = sys.stdin.readline

# n은 학생의 수
# m은 키를 비교한 횟수
n, m = map(int, input().split())

# indegree는 진입차수를 저장하는 리스트
indegree = [0] * (n+1)
graph = [[] for _ in range(n+1)]

# graph 만들고 edge를 받는 쪽인 b의 진입차수 1 증가
for _ in range(m):
    # a -> b
    a, b = map(int, input().split())
    if graph[a]:
        graph[a] += [b]
    else:
        graph[a] = [b]
    indegree[b] += 1

# 처음 상태에서 진입 차수가 0인 vertex를 큐에 삽입
queue = deque()
for i in range(1, n+1):
    if indegree[i] == 0:
        queue.append(i)
# queue에서 원소를 꺼내 해당 원소에 연결된 edge를 제거하고,
# 진입 차수가 0이 된 경우 queue에 삽입
while queue:
    cur = queue.popleft()
    print(cur, end = ' ')
    for i in graph[cur]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)