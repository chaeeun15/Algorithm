def solution(s):
    answer = [-1] * len(s)
    str_dict = {}
    for idx, str in enumerate(s):
        if str in str_dict:
            answer[idx] = idx - str_dict[str]
        str_dict[str] = idx
    return answer