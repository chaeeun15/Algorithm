def solution(n):
    answer = []
    num_list = [[0] * n for _ in range(n)]
    row = -1
    col = 0
    num = 1
    # 크게 3부분으로 나눠지기 때문에 3으로 나눈 나머지로 비교
    # 밑으로 쭉 내려가고 -> 오른쪽으로 쭉 이동하고 -> 왼쪽 위로 쭉 이동하고 반복이니까
    # 밑으로 쭉 내려가는 부분을 먼저 수행해야 하므로 이중 for문을 만들고
    # 밖 for문에 사용되는 i값으로 나머지를 비교해야 한다.
    for i in range(n):
        for j in range(i, n):
            # 밑으로 내려가는 부분
            if i % 3 == 0:
                row += 1
            # 오른쪽으로 이동하는 부분
            elif i % 3 == 1:
                col += 1
            # 왼쪽 위 대각선으로 올라가는 부분
            elif i % 3 == 2:
                col -= 1
                row -= 1
            num_list[row][col] = num
            num += 1
    for i in range(n):
        for j in range(i+1):
            answer.append(num_list[i][j])
    return answer