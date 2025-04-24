from collections import deque
def solution(n, computers):
    answer = 0
    visit = [0] * n
    def bfs(start):
        queue = deque()
        queue.append(start)
        visit[start] = 1
        while queue:
            cur = queue.popleft()
            # 배열이 대칭이라는 보장이 없음
            for i in range(n):
                next_ = computers[cur][i]
                # computers의 값이 1이고
                if next_ == 1:
                    # 아직 방문하지 않은 경우에
                    if visit[i] == 0:
                        visit[i] = 1
                        queue.append(i)
    for i in range(n):
        if visit[i] != 1:
            answer += 1
            bfs(i)
    return answer