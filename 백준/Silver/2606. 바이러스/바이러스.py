import sys
input = sys.stdin.readline

# n은 컴퓨터의 수
n = int(input())
# k는 edge의 수
k = int(input())

graph = [[] for _ in range(n+1)]
for _ in range(k):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

stack = [1]
visit = [0] * (n+1)
visit[1] = 1
cnt = 0
while stack:
    cur = stack.pop()
    cnt += 1
    for next in graph[cur]:
        if visit[next] == 0:
            stack.append(next)
            visit[next] = 1
print(cnt - 1)