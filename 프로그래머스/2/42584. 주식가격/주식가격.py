def solution(prices):
    answer = [i for i in range(len(prices)-1, -1, -1)]
    stack = []
    for sec, price in enumerate(prices):
        while stack and stack[-1][1] > price:
            pre_sec = stack.pop()[0]
            answer[pre_sec] = sec - pre_sec
        stack.append((sec, price))
    return answer