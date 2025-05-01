def solution(lottos, win_nums):
    answer = [0, 0]
    lowest = 0
    win_nums_set = set(win_nums)
    # 최저 순위
    for lotto in lottos:
        if lotto in win_nums_set:
            lowest += 1
    if 2 <= lowest <= 6:
        answer[1] = 7 - lowest
    else:
        answer[1] = 6
    
    # 최고 순위
    highest = lowest + lottos.count(0)
    if 2 <= highest <= 6:
        answer[0] = 7 - highest
    else:
        answer[0] = 6
    return answer