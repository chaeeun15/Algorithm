import sys
input = sys.stdin.readline
input_str = input().strip()
stack = []
# stick_cnt는 쇠막대기의 수
stick_cnt = (len(input_str) - input_str.count('()') * 2)//2
for idx, value in enumerate(input_str):
    if value == ')':
        # 레이저
        if input_str[idx-1] == '(':
            stack.pop()
            stick_cnt += len(stack)
            continue
        # 쇠막대기 끝나는 부분
        elif input_str[idx-1] == ')':
            stack.pop()
            continue
    stack.append(value)
print(stick_cnt)