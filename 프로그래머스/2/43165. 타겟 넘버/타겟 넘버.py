def solution(numbers, target):
    answer = 0
    # idx: 현재 위치, cur: 지금까지 계산 결과
    def dfs(idx, cur):
        nonlocal answer
        # base case: 마지막 숫자까지 계산한 경우
        if idx == len(numbers):
            if cur == target:
                answer += 1
            return
        dfs(idx + 1, cur + numbers[idx])
        dfs(idx + 1, cur - numbers[idx])
    dfs(0, 0)
    return answer