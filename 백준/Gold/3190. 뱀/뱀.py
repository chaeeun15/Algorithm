import sys
from collections import deque
# 보드의 크기
N = int(input())
# 사과의 개수
K = int(input())
# 사과의 위치
apple_list = [[int(i)-1 for i in sys.stdin.readline().strip().split()] for _ in range(K)]
# 뱀이 방향을 바꾸는 횟수
L = int(input())
# 뱀이 방향을 바꾸는 시간, 바꾸는 방향
rotation_dict = {}
for _ in range(L):
    time, direct = sys.stdin.readline().split()
    rotation_dict[int(time)] = direct
map = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        # 사과가 있는 위치는 2로 표시
        if [i, j] in apple_list:
            map[i][j] = 2
start = (0, 0)
cur_col = 0
cur_row = 0
queue = deque()
queue.append(start)
move_c = [0, 1, 0, -1]
move_r = [1, 0, -1, 0]
i = 0
time = 0
while queue:
    next_col = cur_col + move_c[i%4]
    next_row = cur_row + move_r[i%4]
    # 벽에 부딪히거나 몸에 부딪히면 종료
    if next_row < 0 or next_row >= N or next_col < 0 or next_col >= N or (next_col, next_row) in queue:
        break
    queue.append((next_col, next_row))
    # 이동한 곳에 사과가 없으면 꼬리 자르기
    if map[next_col][next_row] == 2:
        # 사과가 있으면 사과는 없어짐
        map[next_col][next_row] = 0
    else:
        queue.popleft()
        
    # 방향 전환
    if time+1 in rotation_dict:
        # 오른쪽으로 회전
        if rotation_dict[time+1] == 'D':
            i += 1
        # 왼쪽으로 회전
        elif rotation_dict[time+1] == 'L':
            i -= 1
    cur_col = next_col
    cur_row = next_row
    time += 1
print(time+1)