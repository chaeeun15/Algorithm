def solution(order):
    answer = 0
    assist = []
    for i in range(1, len(order)+1):
        if i == order[answer]:
            answer += 1
        else:
            assist.append(i)
        while assist and assist[-1] == order[answer]:
            answer += 1
            assist.pop()
    return answer