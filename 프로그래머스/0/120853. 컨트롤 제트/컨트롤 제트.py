def solution(s):
    answer = 0
    str_list = s.split(' ')
    for i, str in enumerate(str_list):
        if str != 'Z':
            answer += int(str)
        else:
            answer -= int(str_list[i-1])
    return answer