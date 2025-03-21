from collections import deque

def solution(board, h, w):
    answer = 0
    queue = deque()
    queue.append((h, w))
    dh = [1, -1, 0, 0]
    dw = [0, 0, -1, 1]
    start = queue.popleft()
    for i in range(4):
        next_h = start[0] + dh[i]
        next_w = start[1] + dw[i]
        if 0<=next_h<=len(board)-1 and 0<=next_w<=len(board)-1:
            if board[start[0]][start[1]] == board[next_h][next_w]:
                answer += 1
    return answer