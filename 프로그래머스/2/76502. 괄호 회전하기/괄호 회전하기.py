def correct(s):
    stack = []
    for i in s:
        if i == ']':
            if not stack or (stack and stack[-1] != '['):
                return 0
            else:
                stack.pop()
                continue
        if i == '}':
            if not stack or (stack and stack[-1] != '{'):
                return 0
            else:
                stack.pop()
                continue
        if i == ')':
            if not stack or (stack and stack[-1] != '('):
                return 0
            else:
                stack.pop()
                continue
        stack.append(i)
    # for문을 다 돌았는데 stack이 아직 비워지지 않은 경우도 올바르지 않은 경우임
    if stack:
        return 0
    return 1
                
def solution(s):
    answer = 0
    s_rotate = ''
    for i in range(len(s)):
        s_rotate = s[i:] + s[:i]
        answer += correct(s_rotate)
    return answer