def solution(brown, yellow):
    # yellow로 만들 수 있는 경우의 수 tuple로 저장
    yellow_grid = [(yellow, 1)]
    for col in range(2, int(yellow**(1/2))+1):
        if yellow % col == 0:
            yellow_grid.append((yellow//col, col))
    
    # yellow의 테두리만큼의 영역이 brown값이랑 같으면 리턴
    for row, col in yellow_grid:
        if (row+2)*2 + col*2 == brown:
            return [row+2, col+2]