def is_winner(board, player):
    win_lines = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],  # 가로
        [0, 3, 6], [1, 4, 7], [2, 5, 8],  # 세로
        [0, 4, 8], [2, 4, 6]              # 대각선
    ]
    return any(board[a] == board[b] == board[c] == player for a, b, c in win_lines)

while True:
    board = input()
    if board == "end":
        break
    
    x_cnt = board.count('X')
    o_cnt = board.count('O')
    
    x_win = is_winner(board, 'X')
    o_win = is_winner(board, 'O')

    # 기본 규칙 위반
    if not (x_cnt == o_cnt or x_cnt == o_cnt + 1):
        print("invalid")
        continue

    # 둘 다 이겼음 → 불가능
    if x_win and o_win:
        print("invalid")
        continue

    # X가 이겼다면 X는 O보다 1개 많아야 함
    if x_win and x_cnt != o_cnt + 1:
        print("invalid")
        continue

    # O가 이겼다면 X와 O 개수 같아야 함
    if o_win and x_cnt != o_cnt:
        print("invalid")
        continue

    # 승자 없음 → 무승부 가능 → 9칸 모두 채워졌을 때만 valid
    if not x_win and not o_win and x_cnt + o_cnt != 9:
        print("invalid")
        continue

    print("valid")
