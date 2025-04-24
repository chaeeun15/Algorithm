from collections import deque
def solution(maps):
    answer = 0
    queue = deque()
    # 시작 위치 (0, 0)과 출발지로부터 현재까지의 거리 1
    queue.append((0, 0, 1))
    # 방문하지 않은 경우를 1로 설정
    visit = [[1] * len(maps[0]) for _ in range(len(maps))]
    visit[0][0] = 0
    while queue:
        start_r, start_c, shortest_dis = queue.popleft()
        # 목적지에 도착했을 경우 거리를 리턴
        if start_r == len(maps)-1 and start_c == len(maps[0])-1:
            answer = shortest_dis
            return answer
        dr = [1, 0, -1, 0]
        dc = [0, 1, 0, -1]
        for i in range(4):
            next_r = start_r + dr[i]
            next_c = start_c + dc[i]
            if 0 <= next_r < len(maps) and 0 <= next_c < len(maps[0]):
                if maps[next_r][next_c] == 1:
                    if visit[next_r][next_c] == 1:
                        visit[next_r][next_c] = 0
                        if (next_r, next_c) not in queue:
                            queue.append((next_r, next_c, shortest_dis+1))
    return -1