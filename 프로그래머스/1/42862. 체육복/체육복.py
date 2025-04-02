def solution(n, lost, reserve):
    cnt = 0
    overlap = set(lost) & set(reserve)
    lost = sorted(set(lost) - overlap)
    reserve = sorted(set(reserve) - overlap)
    lost_people = len(lost)
    for r in reserve:
        if r-1 in lost:
            cnt += 1
            lost.remove(r-1)
        elif r+1 in lost:
            cnt += 1
            lost.remove(r+1)
    return n - lost_people + cnt