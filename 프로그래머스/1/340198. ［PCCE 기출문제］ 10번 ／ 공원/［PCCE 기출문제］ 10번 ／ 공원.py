def solution(mats, park):
    mats.sort()
    mats.reverse()
    for mat in mats:
        for row in range(len(park)-mat+1):
            for col in range(len(park[0])-mat+1):
                all_minus = True
                for mat_row in range(mat):
                    for mat_col in range(mat):
                        if park[row + mat_row][col + mat_col] != "-1":
                            all_minus = False
                            break
                if all_minus == True:
                    return mat
    return -1