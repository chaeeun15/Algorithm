def solution(new_id):
    letter = {'-', '_', '.'}
    # 1단계
    new_id = new_id.lower()
    # 2단계
    level2 = ''
    for i in new_id: 
        if i.isalnum() or i in letter:
            level2 += i
    # 3단계
    while '..' in level2:
        level2 = level2.replace('..', '.')
    # 4단계
    level4 = level2
    if level2 != '':
        if level2[0] == '.':
            level4 = level2.replace('.', '', 1)
        if level2[-1] == '.':
            level4 = level4[:-1]
    # 5단계
    if level4 == '':
        level4 = 'a'
    # 6단계
    level6 = level4
    if len(level4) >= 16:
        level6 = level4[:15]
        if level6[-1] == '.':
            level6 = level6[:-1]
    # 7단계
    answer = level6
    if len(level6) <= 2:
        answer = level6 + level6[-1] * (3-len(level6))
    return answer