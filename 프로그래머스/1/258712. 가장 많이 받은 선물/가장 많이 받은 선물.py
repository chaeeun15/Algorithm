def solution(friends, gifts):
    answer = 0
    friends_dict = dict()
    # friends 리스트를 dict으로 변경
    # 사람 이름을 통해 인덱스를 바로 찾기 위해
    for idx, friend in enumerate(friends):
        friends_dict[friend] = idx
    
    # 주고받은 선물 테이블
    table = [[0] * len(friends) for _ in range(len(friends))]
    # 선물 지수 리스트
    gift_val = [0] * len(friends)
    for gift in gifts:
        # a는 선물 준 사람, b는 선물 받은 사람
        a, b = gift.split()
        gift_val[friends_dict[a]] += 1
        gift_val[friends_dict[b]] -= 1
        table[friends_dict[a]][friends_dict[b]] += 1
    
    # 각각 선물을 얼마만큼 받을 예정인지
    get_gift = [0] * len(friends)
    for i in range(len(friends)):
        for j in range(len(friends)):
            if i == j:
                continue
            # 어차피 table은 서로 대칭이니까
            # table[i][j] < table[j][i]인 경우는 table 돌면서 확인 가능
            if table[i][j] > table[j][i]:
                get_gift[i] += 1
            elif table[i][j] == table[j][i]:
                if gift_val[i] > gift_val[j]:
                    get_gift[i] += 1
    
    return max(get_gift)