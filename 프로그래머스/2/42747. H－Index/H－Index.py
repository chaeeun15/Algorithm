def solution(citations):
    citations.sort()
    h = citations[len(citations)//2]
    cnt = 0
    while cnt != h:
        cnt = 0
        for citation in citations:
            if citation >= h:
                cnt += 1
        h = (h + cnt)//2
    return cnt