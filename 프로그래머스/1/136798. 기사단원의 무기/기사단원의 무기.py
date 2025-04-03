def solution(number, limit, power):
    answer = 0
    for i in range(1, number+1):
        divisor_cnt = divisor(i)
        if divisor_cnt > limit:
            answer += power
        else:
            answer += divisor_cnt
    return answer

def divisor(number):
    cnt = 0
    for i in range(1, int(number**(1/2)) + 1):
        if number % i == 0:
            cnt += 2
            if i**2 == number:
                cnt -= 1
    return cnt