def solution(n, times):
    start = 0
    end = min(times) * n
    answer = 0
    while start <= end:
        people = 0
        mid = (start+end)//2
        for time in times:
            people += mid//time
            # 중간에 넘어버리면 끝까지 계산할 필요 없이 바로 멈춤
            if people >= n:
                break
        if people >= n:
            answer = mid
            end = mid-1
        else:
            start = mid+1
    return answer