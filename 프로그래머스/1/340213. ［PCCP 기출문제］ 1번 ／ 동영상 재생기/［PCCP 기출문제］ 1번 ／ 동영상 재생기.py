def solution(video_len, pos, op_start, op_end, commands):
    pos = time_to_sec(pos)
    video_len = time_to_sec(video_len)
    op_start = time_to_sec(op_start)
    op_end = time_to_sec(op_end)
    for command in commands:
        if op_start <= pos <= op_end:
            pos = op_end
        if command == "prev":
            if pos-10 < 0:
                pos = 0
                continue
            pos -= 10
        elif command == "next":
            if pos+10 > video_len:
                pos = video_len
                continue
            pos += 10
    if op_start <= pos <= op_end:
            pos = op_end
    print(pos, op_end)
    return sec_to_time(pos)

def time_to_sec(time):
    min = int(time[:2])
    sec = int(time[3:])
    return min*60+sec
def sec_to_time(sec):
    time_min = str(sec//60)
    time_sec = str(sec%60)
    if sec//60 < 10:
        time_min = "0" + str(sec//60)
    if sec%60 < 10:
        time_sec = "0" + str(sec%60)
    return time_min + ":" + time_sec