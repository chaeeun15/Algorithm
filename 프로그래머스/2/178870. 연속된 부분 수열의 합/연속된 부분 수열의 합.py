def solution(sequence, k):
    answer = []
    left = 0
    right = 0
    cur_sum = sequence[0]
    while right < len(sequence):
        if cur_sum < k:
            right += 1
            if right < len(sequence):
                cur_sum += sequence[right]
        elif cur_sum > k:
            left += 1
            cur_sum -= sequence[left-1]
        else:
            answer.append((right-left, left, right))
            right += 1
            if right < len(sequence):
                cur_sum += sequence[right]
    answer.sort()
    return answer[0][1:]