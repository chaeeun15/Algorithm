def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    answer = ''.join(numbers)
    return "0" if int(answer) == 0 else answer