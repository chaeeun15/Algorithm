from collections import Counter
def solution(k, tangerine):
    count = Counter(tangerine)
    sorted_count = sorted(count.values(), reverse = True)
    total = 0
    answer = 0
    for i in sorted_count:
        total += i
        answer += 1
        if total >= k:
            break
    return answer