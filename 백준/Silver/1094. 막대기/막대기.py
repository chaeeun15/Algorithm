X = int(input())
stick = 64
stick_list = []
if X == 64:
    print("1")
while stick > 1/4:
    answer = 0
    cur_X = X
    if stick//2 <= X:
        stick_list.append(stick//2)
        stick //= 2
    else:
        stick //= 2
    for i in stick_list:
        if i <= cur_X:
            cur_X -= i
            answer += 1
    if cur_X == 0:
        print(answer)
        break