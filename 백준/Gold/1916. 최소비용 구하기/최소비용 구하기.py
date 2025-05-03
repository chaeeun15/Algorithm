import sys
from heapq import heappop, heappush
from collections import defaultdict

input = sys.stdin.readline

# n은 도시의 개수
n = int(input())
# m은 버스의 개수
m = int(input())
# arr는 버스 출발지, 도착지, 비용
arr = []
for _ in range(m):
    arr.append(list(map(int, input().split())))
# start_city는 출발 도시, end_city는 도착 도시
start_city, end_city = map(int, input().split())

# graph = {출발도시: (도착도시, 버스비용)}
graph = defaultdict(list)
for i in arr:
    graph[i[0]].append((i[1], i[2]))

costs = {}
q = []
heappush(q, (start_city, 0))

while q:
    cur_city, cur_cost = heappop(q)
    if cur_city not in costs or cur_cost < costs[cur_city]:
        costs[cur_city] = cur_cost
        for next_city, cost in graph[cur_city]:
            next_cost = cur_cost + cost
            heappush(q, (next_city, next_cost))
print(costs[end_city])