def solution(n, t, m, p):
    answer = ''
    num_str = ''
    for i in range(0, t*m+p):
        num_str += integer(i, n)
    for j in range(p-1, t*m, m):
        answer += num_str[j]
    return answer

def integer(num, n):
    string = ''
    alpha = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    if num == 0:
        return "0"
    while num > 0:
        if num % n >= 10:
            string += alpha[num%n]
        else:
            string += str(num%n)
        num //= n
    return string[::-1]