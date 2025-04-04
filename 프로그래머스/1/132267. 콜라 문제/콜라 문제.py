def solution(a, b, n):
    answer = 0
    while n >= a:
        exchanged = (n // a) * b  # 새로 받은 병
        answer += exchanged
        n = exchanged + (n % a)  # 남은 병으로 다시 계산
        # print(a, b, n, answer)
    return answer
# 재귀로 풀면 런타임 에러 남
# def solution(a, b, n):
    # answer = 0
    # def recursive(a, b, n, answer):
    #     if n < a:
    #         return answer
    #     answer += (n//a)*b
    #     return recursive(a, b, ((n//a)*b + n%a), answer)
    # answer = recursive(a, b, n, answer)
    # return answer