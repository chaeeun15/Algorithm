import math
def solution(fees, records):
    answer = []
    time_dict = {}
    for record in records:
        time, num, inout = record.split()
        if num not in time_dict:
            time_dict[num] = ["IN", time_to_min(time) * (-1)]
        else:
            if inout == 'IN':
                time_dict[num][0] = "IN"
                time_dict[num][1] -= time_to_min(time)
            elif inout == 'OUT':
                time_dict[num][0] = "OUT"
                time_dict[num][1] += time_to_min(time)
    
    # num_fee는 차량 번호, 요금을 담은 dict
    num_fee = {}
    for k, v in time_dict.items():
        # 만약 출차 기록이 없다면 23:59에 출차된 것으로 간주 
        if v[0] == 'IN':
            time_dict[k][0] = 'OUT'
            time_dict[k][1] += time_to_min('23:59')
        time = v[1] - fees[0]
        if time > 0:
            num_fee[k] = fees[1] + math.ceil(time/fees[2]) * fees[3]
        else:
            num_fee[k] = fees[1]
    answer = list(map(num_fee.get, sorted(num_fee)))
    return answer

def time_to_min(time):
    hour = int(time[:2])
    minute = int(time[3:])
    return hour*60 + minute