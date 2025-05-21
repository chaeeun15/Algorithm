from collections import deque
def solution(dirs):
    answer = 0
    visit = set()
    curX, curY = 5, 5
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    direction = {'R': 0, 'D': 1, 'L': 2, 'U': 3}
    for d in dirs:
        nextX = curX + dx[direction[d]]
        nextY = curY + dy[direction[d]]
        if not (0 <= nextX <= 10 and 0 <= nextY <= 10):
            continue
        visit.add((curX, curY, nextX, nextY))
        visit.add((nextX, nextY, curX, curY))
        curX = nextX
        curY = nextY
    return len(visit)//2