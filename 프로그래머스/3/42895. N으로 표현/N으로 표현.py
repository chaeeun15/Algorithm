def solution(N, number):
    answer = -1
    set_list = []
    # N 하나만으로 number를 만들 수 있다면 바로 1 리턴
    if N == number:
        return 1
    # 중복을 제거해야 함으로 set을 원소로 갖는 리스트 만듦
    # 최솟값이 8보다 크면 -1을 리턴해야 하니까 8칸만 만듦
    for _ in range(8):
        set_list.append(set())
    
    # N을 연결해서 만들 수 있는 값들은 먼저 넣음
    # N이 5면 5, 55, 555, ...
    for i in range(len(set_list)):
        set_list[i].add(int(str(N) * (i+1)))
    
    for i in range(1, 8):
        for j in range(i):
            for op1 in set_list[j]:
                for op2 in set_list[i-j-1]:
                    # +, -, *, // 순서
                    set_list[i].add(op1+op2)
                    set_list[i].add(op1-op2)
                    set_list[i].add(op1*op2)
                    if op2 != 0:
                        set_list[i].add(op1//op2)
        # number를 만들 수 있으면 바로 리턴. 최솟값을 구하는 거니까
        if number in set_list[i]:
            return i+1
    return answer