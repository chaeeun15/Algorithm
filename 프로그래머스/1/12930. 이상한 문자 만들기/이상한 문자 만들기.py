def solution(s):
    answer = ''
    str_list = list(s.split(" "))
    for i, str in enumerate(str_list):
        for j in range(len(str)):
            if j % 2 == 0:
                answer += str[j].upper()
            else:
                answer += str[j].lower()
        if i != len(str_list) - 1:
            answer += ' '
    return answer