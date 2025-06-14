import sys
input = sys.stdin.readline

# n은 보드의 크기
n = int(input())

board = []
for _ in range(n):
    board.append(list(input().strip()))

# 전체 보드에서 인접한 사탕의 최대 개수 구하는 함수
def checkMaxCnt(board):
    max_cnt = 1
    for i in range(len(board)):
        cnt = 1
        # 행에서 인접한 사탕의 최대 개수 구하기
        for j in range(1, len(board)):
            if board[i][j] == board[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(cnt, max_cnt)
        # 열에서 인접한 사탕의 최대 개수 구하기
        for j in range(1, len(board)):
            if board[j][i] == board[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(cnt, max_cnt)
    return max_cnt

total_max_cnt = 1
for i in range(n-1):
    for j in range(n-1):
        if board[i][j] != board[i][j+1]:
            # 바꾸고 최대 개수 확인하고, 다시 원상복귀
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            total_max_cnt = max(total_max_cnt, checkMaxCnt(board))
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
        if board[i][j] != board[i+1][j]:
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            total_max_cnt = max(total_max_cnt, checkMaxCnt(board))
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
print(total_max_cnt)