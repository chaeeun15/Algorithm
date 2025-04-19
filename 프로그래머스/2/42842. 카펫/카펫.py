def solution(brown, yellow):
    # 24->24*1 / 12*2 / 8*3 / 6*4
    # yellow로 만들 수 있는 경우의 수 tuple로 저장
    yellow_grid = [(yellow, 1)]
    for col in range(2, int(yellow**(1/2))+1):
        if yellow % col == 0:
            yellow_grid.append((yellow//col, col))
    print(yellow_grid)
    for row, col in yellow_grid:
        if (row+2)*2 + col*2 == brown:
            return [row+2, col+2]