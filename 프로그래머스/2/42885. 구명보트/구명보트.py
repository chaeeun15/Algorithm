def solution(people, limit):
    answer = 0
    people.sort()
    start = 0
    end = len(people) - 1
    while start <= end:
        # limit를 넘는 경우 end를 1 줄임
        # 그 제외된 사람은 무조건 구명보트를 혼자 써야 하는 경우니까 answer는 1 증가
        if people[start] + people[end] > limit:
            end -= 1
            answer += 1
        # limit를 안 넘는 경우 두 사람을 태운 거니까 start 1 증가, end 1 감소
        else:
            answer += 1
            start += 1
            end -= 1
    return answer