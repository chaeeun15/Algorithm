def solution(arr):
    minimum = max(arr)
    maximum = 1
    for m in arr:
        maximum *= m
    for i in range(minimum, maximum+1):
        cnt = 0
        for a in arr:
            if i % a != 0:
                cnt += 1
        if cnt == 0:
            return i