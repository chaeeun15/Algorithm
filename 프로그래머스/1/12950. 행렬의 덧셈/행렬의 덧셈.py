def solution(arr1, arr2):
    answer = []
    for i, row1 in enumerate(arr1):
        row2 = arr2[i]
        answer.append([x+y for x, y in zip(row1, row2)])
    return answer