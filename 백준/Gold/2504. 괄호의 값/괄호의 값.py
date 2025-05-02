import sys
input = sys.stdin.readline
arr = input()
stack = []
answer = 0
tmp = 1

for i, val in enumerate(arr):
    if val == '(':
        tmp *= 2
        stack.append('(')
    elif val == '[':
        tmp *= 3
        stack.append('[')
    elif val == ')':
        if not stack or stack[-1] != '(':
            answer = 0
            break
        if arr[i-1] == '(':
            answer += tmp
        tmp //= 2
        stack.pop()
    elif val == ']':
        if not stack or stack[-1] != '[':
            answer = 0
            break
        if arr[i-1] == '[':
            answer += tmp
        tmp //= 3
        stack.pop()

if stack:
    print(0)
else:
    print(answer)