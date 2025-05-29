def solution(numbers):
    answer = []
    for number in numbers:
        # 마지막이 0으로 끝나는 경우(짝수인 경우) 그 비트만 1로 바꿔주면 됨
        if number % 2 == 0:
            answer.append(number+1)
        # 홀수인 경우 가장 오른쪽에 있는 0을 1로 바꾸고,
        # 그 다음 오른쪽의 1을 0으로 바꿔주면 됨
        else:
            binary = bin(number)[2:]
            # 7처럼 0이 없는 경우 
            if '0' not in binary:
                binary = '10' + binary[1:]
            # 0이 있는 경우
            else:
                i = binary.rfind('0')
                if i < len(binary) - 2:
                    binary = binary[:i] + '10' + binary[i+2:]
                else:
                    binary = binary[:i] + '10'
            answer.append(int(binary, 2))
    return answer