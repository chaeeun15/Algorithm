def solution(want, number, discounts):
    answer = 0
    for idx, discount in enumerate(discounts):
        number_list = [0] * len(number)
        if discount in want:
            for i in discounts[idx:idx+10]:
                if i in want:
                    number_list[want.index(i)] += 1
            if number_list == number:
                answer += 1
    return answer