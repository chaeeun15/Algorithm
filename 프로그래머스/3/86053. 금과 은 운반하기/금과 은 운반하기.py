def solution(a, b, g, s, w, t):
    # 특정 시간일 때 조건을 만족할 수 있는지 이분탐색으로 검사
    # 최악의 경우: ((2*10^9) * (2*10^5))/1
    start = 0
    end = 4*10**14
    while start < end:
        mid = (start + end) // 2
        gold = silver = total = 0
        
        for i in range(len(t)):
            # 운반 횟수는 총 걸린 시간을 한 번 운반할 때 걸린 시간으로 나눈 값
            move_cnt = mid // (2*t[i])
            # 처음 운반은 편도로 가능
            if mid%(2*t[i]) >= t[i]:
                move_cnt += 1
            gold += min(g[i], move_cnt * w[i])
            silver += min(s[i], move_cnt * w[i])
            total += min(g[i] + s[i], move_cnt * w[i])
        # 조건을 만족하는 경우(시간이 충분한 경우) -> 더 적은 시간이 가능할 수도 있으므로 시간을 줄여봄
        # 현재 mid값이 포함되도록 end = mid로 변경
        if gold >= a and silver >= b and total >= a+b:
            end = mid
        # 조건 만족하지 못하는 경우 -> 시간을 늘림
        # 현재 mid 값이 포함될 필요 없음
        else:
            start = mid + 1
    return start