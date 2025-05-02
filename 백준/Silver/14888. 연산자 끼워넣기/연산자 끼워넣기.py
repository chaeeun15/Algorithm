import sys
input = sys.stdin.readline
N = int(input()) # 숫자의 개수
numbers = list(map(int, input().split()))
operations = list(map(int, input().split()))
min_num = int(1e9)
max_num = int(-1e9)

def dfs(depth, total, plus, minus, multiply, divide):
    global max_num, min_num
    # base case
    if depth == N:
        max_num = max(max_num, total)
        min_num = min(min_num, total)
        return
    if plus:
        dfs(depth+1, total + numbers[depth], plus-1, minus, multiply, divide)
    if minus:
        dfs(depth+1, total - numbers[depth], plus, minus-1, multiply, divide)
    if multiply:
        dfs(depth+1, total * numbers[depth], plus, minus, multiply-1, divide)
    if divide:
        dfs(depth+1, int(total / numbers[depth]), plus, minus, multiply, divide - 1)

dfs(1, numbers[0], operations[0], operations[1], operations[2], operations[3])
print(max_num)
print(min_num)