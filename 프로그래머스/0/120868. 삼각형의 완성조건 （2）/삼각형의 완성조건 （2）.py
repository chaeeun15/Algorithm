def solution(sides):
    # 가장 긴 변이 sides에 있는 경우: sides.max() - sides.min() + 1 ~ sides.max()
    # 나머지 한 변이 가장 긴 경우: sides.max() + 1 ~ sides.min() + sides.max() - 1
    return 2 * min(sides) - 1