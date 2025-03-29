from collections import deque
def solution(n, m, section):
    cnt = 0
    queue = deque(section)
    while queue:
        start = queue.popleft()
        cnt += 1
        while queue and queue[0] < start+m:
            queue.popleft()
    return cnt