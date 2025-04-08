from collections import deque

def solution(priorities, location):
    answer = 0
    queue = deque([i for i in range(len(priorities))])
    cur_priorities = priorities[:]
    
    while queue:
        cur = queue.popleft()
        # 만약 현재 꺼내진 프로세스의 우선순위가 가장 높다면
        # 큐에 다시넣지 않고 실행 횟수 증가
        if priorities[cur] == max(cur_priorities):
            answer += 1
            cur_priorities.remove(priorities[cur])
            # 만약 지금 실행된 프로세스가 원하는 location의 프로세스라면
            # 실행 횟수 리턴
            if cur == location:
                return answer
        # 지금 꺼내진 프로세스보다 높은 우선 순위를 가진 다른 프로세스가 있다면
        # 다시 큐에 넣음
        else:
            queue.append(cur)
    return answer