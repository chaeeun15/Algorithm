import sys
N, M = map(int, input().split())
board = [sys.stdin.readline().strip() for _ in range(N)]
# white는 0, black은 1로 설정
board = [[0 if i == 'W' else 1 for i in row] for row in board]
# 모든 칸을 다 바꿔야 하는 경우는 32번
answer = 32
for idx_col in range(len(board) - 7):
    for idx_row in range(len(board[0]) - 7):
        cur = board[idx_col][idx_row]
        black_cnt = 0
        white_cnt = 0
        for col in range(8):
            for row in range(8):
                # 왼쪽 위가 black인데 짝수 칸이 white이면 1 증가
                # 반대로 왼쪽 위가 white인데 짝수 칸이 black이면 1 증가
                if ((idx_col+col) + (idx_row+row)) % 2 == 0:
                    if board[idx_col+col][idx_row+row] == 0:
                        black_cnt += 1
                    else:
                        white_cnt += 1
                else:
                    if board[idx_col+col][idx_row+row] == 0:
                        white_cnt += 1
                    else:
                        black_cnt += 1
        # 왼쪽 위가 black일 때, white일 때 둘 다 구해서 작은 값이 정답
        answer = min(black_cnt, white_cnt, answer)
print(answer)