from collections import Counter
def solution(topping):
    answer = 0
    up_bro = set()
    count = Counter(topping)
    for top in topping:
        up_bro.add(top)
        count[top] -= 1
        if count[top] == 0:
            del count[top]
        if len(up_bro) == len(count):
            answer += 1
    return answer