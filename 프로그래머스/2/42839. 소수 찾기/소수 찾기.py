from itertools import permutations
def solution(numbers):
    answer = 0
    number = [i for i in numbers]
    number_dict = {}
    # 만들 수 있는 모든 숫자 dict에 저장
    for i in range(len(numbers)+1):
        for tuple in permutations(number, i):
            if tuple:
                number_dict[int(''.join(tuple))] = True
    
    # 소수 개수 세기
    for num in number_dict.keys():
        cnt = 0
        if num != 0 and num != 1:
            for i in range(2, int(num**(1/2))+1):
                if num%i == 0:
                    cnt += 1
            if cnt == 0:
                answer += 1
    return answer