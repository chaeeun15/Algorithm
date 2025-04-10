def solution(arr, divisor):
    answer = []
    for number in arr:
        if number % divisor == 0:
            answer.append(number)
    return [-1] if not answer else sorted(answer)