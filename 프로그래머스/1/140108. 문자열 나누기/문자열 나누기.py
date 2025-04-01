from collections import deque
def solution(s):
    answer = 0
    queue = deque(s)
    while queue:
        start_cnt = 0
        another_cnt = 0
        start = queue.popleft()
        if not queue:
            answer += 1
        start_cnt += 1
        while queue:
            if queue.popleft() == start:
                start_cnt += 1
            else:
                another_cnt += 1
            if start_cnt == another_cnt:
                answer += 1
                break
            if not queue:
                answer += 1
    return answer