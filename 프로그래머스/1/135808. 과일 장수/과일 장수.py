def solution(k, m, score):
    answer = 0
    score.sort()
    for i in range(len(score), 0, -m):
        if score[i-m:i] and len(score) > m:
            min_score = min(score[i-m:i])
            answer += min_score * m
    return answer