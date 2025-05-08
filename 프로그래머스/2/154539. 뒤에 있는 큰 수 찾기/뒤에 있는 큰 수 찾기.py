def solution(numbers):
    answer = [-1] * len(numbers)
    stack = []
    for idx, number in enumerate(numbers):
        while stack and stack[-1][1] < number:
            i, n = stack.pop()
            answer[i] = number
        stack.append((idx, number))
    return answer