from collections import deque
from collections import defaultdict
def solution(n, edge):
    graph = {}
    for v, w in edge:
        if v not in graph:
            graph[v] = [w]
        else:
            graph[v].append(w)
        if w not in graph:
            graph[w] = [v]
        else:
            graph[w].append(v)
    distance = [int(1e9)] * n
    queue = deque()
    queue.append(1)
    distance[0] = 0
    while queue:
        cur_node = queue.popleft()
        for next_node in graph[cur_node]:
            if distance[next_node - 1] == int(1e9):
                distance[next_node - 1] = distance[cur_node - 1] + 1
                queue.append(next_node)
    return distance.count(max(distance))