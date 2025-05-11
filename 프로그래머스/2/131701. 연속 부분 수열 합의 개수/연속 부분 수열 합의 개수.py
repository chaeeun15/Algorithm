def solution(elements):
    answer_set = set()
    elements_list = elements * 2
    for i in range(len(elements)):
        for j in range(i, len(elements)+i):
            answer_set.add(sum(elements_list[i:j+1]))
    return len(answer_set)