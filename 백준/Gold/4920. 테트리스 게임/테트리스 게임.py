import sys
input = sys.stdin.readline

# 일자 모양(눕힌 상태)
def line_1():
    sum_num = -int(1e9)
    for row in range(n):
        for col in range(n-3):
            sum_num = max(sum_num, table[row][col] + table[row][col+1] + table[row][col+2] + table[row][col+3])
    return sum_num
# 일자 모양(세운 상태)
def line_2():
    sum_num = -int(1e9)
    for row in range(n-3):
        for col in range(n):
            sum_num = max(sum_num, table[row][col] + table[row+1][col] + table[row+2][col] + table[row+3][col])
    return sum_num
# ㄹ 모양(눕힌 상태)
def f_1():
    sum_num = -int(1e9)
    for row in range(n-1):
        for col in range(n-2):
            sum_num = max(sum_num, table[row][col] + table[row][col+1] + table[row+1][col+1] + table[row+1][col+2])
    return sum_num
# ㄹ 모양(세운 상태)
def f_2():
    sum_num = -int(1e9)
    for row in range(n-2):
        for col in range(1, n):
            sum_num = max(sum_num, table[row][col] + table[row+1][col-1] + table[row+1][col] + table[row+2][col-1])
    return sum_num
# ㄱ 모양
def r_1():
    sum_num = -int(1e9)
    for row in range(n-1):
        for col in range(n-2):
            sum_num = max(sum_num, table[row][col] + table[row][col+1] + table[row][col+2] + table[row+1][col+2])
    return sum_num
# ㄱ 오른쪽으로 90도 돌린 모양(L 거꾸로)
def r_2():
    sum_num = -int(1e9)
    for row in range(n-2):
        for col in range(1, n):
            sum_num = max(sum_num, table[row][col] + table[row+1][col] + table[row+2][col] + table[row+2][col-1])
    return sum_num
# ㄱ 오른쪽으로 180도 돌린 모양(ㄴ 모양)
def r_3():
    sum_num = -int(1e9)
    for row in range(n-1):
        for col in range(n-2):
            sum_num = max(sum_num, table[row][col] + table[row+1][col] + table[row+1][col+1] + table[row+1][col+2])
    return sum_num
# ㄱ 왼쪽으로 90도 돌린 모양
def r_4():
    sum_num = -int(1e9)
    for row in range(n-2):
        for col in range(n-1):
            sum_num = max(sum_num, table[row][col] + table[row][col+1] + table[row+1][col] + table[row+2][col])
    return sum_num
# ㅜ 모양
def n_1():
    sum_num = -int(1e9)
    for row in range(n-1):
        for col in range(n-2):
            sum_num = max(sum_num, table[row][col] + table[row][col+1] + table[row][col+2] + table[row+1][col+1])
    return sum_num
# ㅏ 모양
def n_2():
    sum_num = -int(1e9)
    for row in range(n-2):
        for col in range(n-1):
            sum_num = max(sum_num, table[row][col] + table[row+1][col] + table[row+2][col] + table[row+1][col+1])
    return sum_num
# ㅗ 모양
def n_3():
    sum_num = -int(1e9)
    for row in range(1, n):
        for col in range(1, n-1):
            sum_num = max(sum_num, table[row][col] + table[row-1][col] + table[row][col-1] + table[row][col+1])
    return sum_num
# ㅓ 모양
def n_4():
    sum_num = -int(1e9)
    for row in range(n-2):
        for col in range(1, n):
            sum_num = max(sum_num, table[row][col] + table[row+1][col] + table[row+2][col] + table[row+1][col-1])
    return sum_num
# 정사각형 모양
def square():
    sum_num = -int(1e9)
    for row in range(n-1):
        for col in range(n-1):
            sum_num = max(sum_num, table[row][col] + table[row+1][col] + table[row+1][col+1] + table[row][col+1])
    return sum_num

number = 0
while True:
    # n은 표의 한 변의 길이
    n = int(input())
    if n == 0:
        break
    table = [[int(i) for i in input().split()] for _ in range(n)]
    number += 1

    result1 = line_1()
    result2 = line_2()
    result3 = f_1()
    result4 = f_2()
    result5 = r_1()
    result6 = r_2()
    result7 = r_3()
    result8 = r_4()
    result9 = n_1()
    result10 = n_2()
    result11 = n_3()
    result12 = n_4()
    result13 = square()

    result = max(result1, result2, result3, result4, result5, result6, result7, result8, result9, result10, result11, result12, result13)
    print(str(number) + '. ' + str(result))