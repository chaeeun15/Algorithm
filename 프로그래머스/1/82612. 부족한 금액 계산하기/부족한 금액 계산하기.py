def solution(price, money, count):
    answer = money
    for i in range(1, count+1):
        answer -= i*price
        print(answer)
    return answer*(-1) if answer < 0 else 0