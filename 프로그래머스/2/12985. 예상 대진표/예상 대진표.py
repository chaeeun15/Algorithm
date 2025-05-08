def solution(n,a,b):
    answer = 1
    while True:
        if abs(a-b) == 1:
            if a < b:
                if a%2 == 1 and b%2 == 0:
                    break
            else:
                if a%2 == 0 and b%2 == 1:
                    break
        a = (a+1)//2
        b = (b+1)//2
        answer += 1
    return answer