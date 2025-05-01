def solution(N, stages):
    fail_dict = {i+1: 0 for i in range(N)} # 실패율을 담은 dict
    people_num = len(stages) # 전체 사람 수
    stages.sort()
    stage_people = 0 # 해당 스테이지를 깬 사람 수
    for idx, stage in enumerate(stages):
        stage_people += 1
        if idx == len(stages) - 1:
            if stage != N+1:
                fail_dict[stage] = stage_people/people_num
        elif stages[idx] != stages[idx+1]:
            fail_dict[stage] = stage_people/people_num
            people_num -= stage_people
            stage_people = 0
    # 스테이지를 실패율의 내림차순으로 정렬
    answer = sorted(fail_dict, key=lambda x: fail_dict[x], reverse = True)
    return answer