def solution(s):
    answer = [0, 0] # 이진변환 횟수, 제거한 0의 개수
    change = s
    while change != '1' and answer[0] < 5:
        s = change
        change = ''
        for i in s:
            if i == '0':
                answer[1] += 1
            else:
                change += i
        change = bin(len(change))[2:]
        answer[0] += 1
    return answer