from collections import deque
def solution(x, y, n):
    queue = deque()
    # 시작 값, 연산 횟수 (y -> x)
    queue.append((y, 0))
    if x == y:
        return 0
    while queue:
        cur, times = queue.popleft()
        if cur == x:
            return times
        elif cur > x:
            if cur%3 == 0:
                queue.append((cur//3, times+1))
            if cur%2 == 0:
                queue.append((cur//2, times+1))
            queue.append((cur-n, times+1))
    return -1