import heapq
def solution(book_time):
    answer = 0
    rooms = []
    heapq.heapify(rooms)
    book_time.sort(key = lambda x: (x[0][:2], x[0][3:]))
    for book in book_time:
        start, end = book[0], book[1]
        if rooms and time_to_minute(start) >= rooms[0]:
            heapq.heappop(rooms)
        heapq.heappush(rooms, time_to_minute(end)+10)
    return len(rooms)
def time_to_minute(time):
    return int(time[:2])*60+int(time[3:])