def solution(nums):
    answer = 0
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            for k in range(j+1, len(nums)):
                num = nums[i] + nums[j] + nums[k]
                cnt = 0
                for n in range(2, int(num**(1/2))+1):
                    if num % n == 0:
                        cnt += 1
                if cnt == 0:
                    answer += 1
    return answer