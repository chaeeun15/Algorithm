from collections import deque

def solution(progresses, speeds):
    answer = []
    day_queue = deque()
    # 각각의 작업이 완료될 때까지 걸리는 시간 queue에 담기
    for idx, progress in enumerate(progresses):
        day_queue.append((100-progress)//speeds[idx] if (100-progress)%speeds[idx] == 0 else (100-progress)//speeds[idx] + 1)
    
    pre = day_queue.popleft()
    answer.append(1)
    i = 0
    while day_queue:
        cur = day_queue.popleft()
        if cur <= pre:
            answer[i] += 1
        else:
            answer.append(1)
            pre = cur
            i += 1
    return answer