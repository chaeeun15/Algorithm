def solution(s):
    answer = []
    s_list = s[2:-2].split('},{')
    s_list.sort(key = lambda x: len(x))
    for i in s_list:
        cur_list = map(int, i.split(','))
        for c in cur_list:
            if c not in answer:
                answer.append(c)
    return answer