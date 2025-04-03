def solution(babbling):
    answer = 0
    pronounce = ["aya", "ye", "woo", "ma"]
    for bab in babbling:
        # pronounce 안에 있는 문자열과 같은지 확인할 문자열
        stack_str = ''
        # 이전 문자열과 같은지 확인용
        pre_str = ''
        for i in bab:
            stack_str += i
            # pronounce 안에 있고, 이전 문자열과 다른 경우에만 stack_str에서 문자열 제거
            if stack_str in pronounce and stack_str != pre_str:
                pre_str = stack_str
                stack_str = stack_str[:-3]
        # 다 없어진 경우에만 answer 1 추가
        if stack_str == '':
            answer += 1
    return answer