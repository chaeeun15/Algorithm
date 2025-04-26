def solution(absolutes, signs):
    answer = 0
    for idx, absolute in enumerate(absolutes):
        if signs[idx] == True:
            answer += absolute
        else:
            answer -= absolute
    return answer