def solution(park, routes):
    route_dict = {'E': [0,1], 'N': [-1,0], 'S': [1,0], 'W': [0,-1]}
    # 시작 위치 찾기
    for idx, row in enumerate(park):
        if 'S' in row:
            cur_pos = [idx, row.index('S')]
    
    # routes 돌면서 확인
    for route in routes:
        direction, distance = route.split()
        next_pos = cur_pos
        cnt = 0
        for i in range(1, int(distance)+1):
            next_pos = [x + y for x, y in zip(route_dict[direction], next_pos)]
            if 0 <= next_pos[0] < len(park) and 0 <= next_pos[1] < len(park[0]):
                if park[next_pos[0]][next_pos[1]] != 'X':
                    cnt += 1
        # 이동하면서 문제가 없었던 경우에만 cur_pos 업데이트
        if cnt == int(distance):
            cur_pos = next_pos
    return cur_pos