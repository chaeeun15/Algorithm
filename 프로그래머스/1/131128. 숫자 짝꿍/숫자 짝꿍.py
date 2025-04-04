from collections import Counter

def solution(X, Y):
    counter_x = Counter(X)
    counter_y = Counter(Y)
    
    result = []
    for digit in map(str, range(9, -1, -1)):
        cnt = min(counter_x[digit], counter_y[digit])
        if cnt > 0:
            result.append(digit * cnt)

    if not result:
        return "-1"
    
    answer = ''.join(result)
    return "0" if answer[0] == "0" else answer