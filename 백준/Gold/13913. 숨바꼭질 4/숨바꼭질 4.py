import sys
from collections import deque
input = sys.stdin.readline

# n은 수빈이의 위치, k는 동생의 위치
n, k = map(int, input().split())

queue = deque()
queue.append((n, []))
visit = [0] * 100001

if n > k:
    print(n-k)
    for x in range(n, k-1, -1):
        print(x, end = " ")
else:
    while queue:
        cur, way = queue.popleft()
        next_way = way + [cur]
        if cur == k:
            ans = next_way
            break
        arr = [cur + 1, cur - 1, cur * 2]
        for a in arr:
            if 0 <= a <= 100000 and visit[a] == 0:
                queue.append((a, next_way))
                visit[a] = 1
    print(len(ans) - 1)
    for a in ans:
        print(a, end = " ")