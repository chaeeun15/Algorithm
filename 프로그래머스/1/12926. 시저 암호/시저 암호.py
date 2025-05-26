def solution(s, n):
    answer = ''
    for i in s:
        new = ord(i) + n
        if i.isalpha():
            if 97 <= ord(i) <= 122:               
                if new > 122:
                    new -= 26
                answer += chr(new)
            elif 65 <= ord(i) <= 90:
                if new > 90:
                    new -= 26
                answer += chr(new)
        else:
            answer += i
    return answer