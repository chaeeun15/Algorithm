def solution(clothes):
    answer = 1
    clothes_dict = {clothe[1]: [0] for clothe in clothes}
    for clothe in clothes:
        clothes_dict[clothe[1]] += [clothe[0]]
    
    for name in clothes_dict.values():
        answer *= len(name)
    return answer - 1