def solution(babbling):
    answer = 0
    possible = {"aya", "ye", "woo", "ma"}
    
    for bab in babbling:
        stack = []
        for b in bab:
            stack.append(b)
            if ''.join(stack) in possible:
                stack = []
        if not stack:
            answer += 1       
    return answer