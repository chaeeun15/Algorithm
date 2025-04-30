def solution(n):
    three = ''
    answer = 0
    while n >= 1:
        three += str(n % 3)
        n //= 3
    print(three)
    for i, num in enumerate(three[::-1]):
        answer += int(num) * 3**(i)
    return answer