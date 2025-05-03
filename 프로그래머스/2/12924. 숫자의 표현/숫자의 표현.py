def solution(n):
    answer = 0
    start = 1
    end = 2
    cur_sum = 3
    while start != n//2 + 1:
        if cur_sum < n:
            end += 1
            cur_sum += end
        elif cur_sum > n:
            start += 1
            cur_sum -= (start - 1) 
        elif cur_sum == n:
            answer += 1
            cur_sum = cur_sum + end + 1 - start
            start += 1
            end += 1
    return answer+1