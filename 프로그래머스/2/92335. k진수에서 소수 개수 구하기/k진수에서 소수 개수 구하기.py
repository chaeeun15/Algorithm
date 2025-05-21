def solution(n, k):
    answer = 0
    num_str = change(n, k)
    temp = ''
    for idx, num in enumerate(num_str):
        if num != '0':
            temp += num
        else:
            if temp != '' and prime(int(temp)):
                answer += 1
            temp = ''
        if idx == len(num_str) - 1:
            if temp != '' and prime(int(temp)):
                answer += 1
    return answer

def change(n, k):
    num_str = ''
    while n > 0:
        num_str += str(n%k)
        n //= k
    return num_str[::-1]

def prime(num):
    if num == 0 or num == 1:
        return False
    for i in range(2, int(num**(1/2))+1):
        if num % i == 0:
            return False
    return True