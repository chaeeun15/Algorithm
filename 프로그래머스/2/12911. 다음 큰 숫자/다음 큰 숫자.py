def solution(n):
    i = 0
    while True:
        i += 1
        if bin(n).count('1') == bin(n+i).count('1'):
            return n+i