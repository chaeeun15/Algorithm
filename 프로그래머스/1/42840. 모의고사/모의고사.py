def solution(answers):
    math1 = [1, 2, 3, 4, 5]
    math1_scr = 0
    math2 = [2, 1, 2, 3, 2, 4, 2, 5]
    math2_scr = 0
    math3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    math3_scr = 0
    result = []
    for idx, answer in enumerate(answers):
        if math1[idx%5] == answer:
            math1_scr += 1
        if math2[idx%8] == answer:
            math2_scr += 1
        if math3[idx%10] == answer:
            math3_scr += 1
    max_scr = max(math1_scr, math2_scr, math3_scr)
    if math1_scr == max_scr:
        result.append(1)
    if math2_scr == max_scr:
        result.append(2)
    if math3_scr == max_scr:
        result.append(3)
    return result