def solution(board, moves):
    answer = 0
    stack = []
    n = len(board) # 격자 한 변의 길이
    for move in moves:
        i = 0
        while board[i][move-1] == 0 and i < n-1:
            i += 1
        if board[i][move-1] != 0:
            stack.append(board[i][move-1])
            board[i][move-1] = 0
        if len(stack) >= 2:
            if stack[-1] == stack[-2]:
                stack = stack[:-2]
                answer += 2
    return answer
