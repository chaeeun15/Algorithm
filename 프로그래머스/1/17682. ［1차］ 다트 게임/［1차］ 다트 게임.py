def solution(dartResult):
    answer = 0
    cur_option = ''
    pre_option = ''
    cur_bonus = ''
    pre_num = ''
    for dart in dartResult[::-1]:
        score = 0
        if dart in {'*', '#'}:
            cur_option = dart
        elif dart in {'S', 'D', 'T'}:
            cur_bonus = dart
        else:
            if pre_num.isdigit():
                dart = '10'
            if cur_bonus == 'D':
                score = int(dart) ** 2
                if cur_option == '*':
                    score *= 2
                elif cur_option == '#':
                    score *= (-1)
                if pre_option == '*':
                    score *= 2
                    pre_option = ''
            elif cur_bonus == 'T':
                score = int(dart) ** 3
                if cur_option == '*':
                    score *= 2
                elif cur_option == '#':
                    score *= (-1)
                if pre_option == '*':
                    score *= 2
                    pre_option = ''
            else:
                score = int(dart)
                if cur_option == '*':
                    score *= 2
                elif cur_option == '#':
                    score *= (-1)
                if pre_option == '*':
                    score *= 2
                    pre_option = ''
            pre_option = cur_option
            cur_option = ''
        pre_num = dart
        answer += score
    return answer