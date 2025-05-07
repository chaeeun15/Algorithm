from collections import deque
def solution(queue1, queue2):
    answer = -2
    cnt = 0
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)
    all_sum = queue1_sum + queue2_sum
    if all_sum%2 != 0:
        return -1
    all_sum //= 2
    queue1_deque = deque(queue1)
    queue2_deque = deque(queue2)
    while queue1_deque and queue2_deque and queue1_sum != all_sum and queue2_sum != all_sum:
        if queue1_sum > queue2_sum:
            popnum = queue1_deque.popleft()
            queue2_deque.append(popnum)
            queue1_sum -= popnum
            queue2_sum += popnum
            cnt += 1
        else:
            popnum = queue2_deque.popleft()
            queue1_deque.append(popnum)
            queue1_sum += popnum
            queue2_sum -= popnum
            cnt += 1
        if cnt > 3*len(queue1):
            return -1
    return cnt if queue1_sum != 0 and queue2_sum != 0 else -1