def solution(a, b):
    date = 0
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    for i in range(a-1):
        date += month[i]
    date += (b-1)
    return day[date%7]