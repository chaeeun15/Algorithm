def solution(schedules, timelogs, startday):
    result = len(schedules)
    for man, timelog in enumerate(timelogs):
        for day, time in enumerate(timelog):
            if (day+startday)%7 != 0 and (day+startday)%7 != 6:
                if time_to_minute(time) > time_to_minute(schedules[man]+10):
                    result -= 1
                    break
    return result

def time_to_minute(time):
    return time//100*60 + time%100