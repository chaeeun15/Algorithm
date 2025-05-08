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