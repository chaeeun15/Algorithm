def solution(s):
    str_list = [int(i) for i in s.split(' ')]
    return str(min(str_list)) + ' ' + str(max(str_list))