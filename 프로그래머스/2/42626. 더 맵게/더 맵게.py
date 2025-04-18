import heapq
def solution(scoville, K):
    cnt = 0
    heapq.heapify(scoville)
    while scoville[0] < K and len(scoville) != 1:
        lowest = heapq.heappop(scoville)
        lower = heapq.heappop(scoville)
        heapq.heappush(scoville, lowest + lower*2)
        cnt += 1
    if len(scoville) == 1 and scoville[0] < K:
        return -1
    return cnt