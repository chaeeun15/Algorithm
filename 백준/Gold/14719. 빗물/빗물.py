import sys
input = sys.stdin.readline
h, w = map(int, input().split())
height = list(map(int, input().split()))
map = [[0] * w for i in range(h)]
# 거꾸로 map 값 설정
for i in range(w):
    for j in range(height[i]):
        map[j][i] = 1

after = -1
distance = 0
for i in range(h):
    before = -1
    for j in range(w):
        if map[i][j] == 1:
            if before != -1:
                distance += (j-before-1)
            before = j
print(distance)