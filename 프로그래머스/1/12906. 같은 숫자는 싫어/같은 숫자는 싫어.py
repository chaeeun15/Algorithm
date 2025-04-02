def solution(arr):
    answer = []
    for i, num in enumerate(arr):
        if not answer:
            answer.append(num)
            continue
        if num != arr[i-1]:
            answer.append(num)
    return answer