def solution(sizes):
    for size in sizes:
        size.sort()
    max_size = [max(size) for size in zip(*sizes)]
    return max_size[0]*max_size[1]