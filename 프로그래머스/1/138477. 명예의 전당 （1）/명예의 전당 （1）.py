def solution(k, score):
    answer = []
    honor = []
    for idx, s in enumerate(score):
        if len(honor) < k:
            honor.append(s)
            answer.append(min(honor))
        else:
            if s >= min(honor):
                min_index = honor.index(min(honor))
                honor[min_index] = s
            answer.append(min(honor))
    return answer