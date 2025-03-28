def solution(bandage, health, attacks):
    total_time = attacks[-1][0]
    attacks_dict = dict(attacks)
    cur_health = health
    success = 0
    for time in range(total_time+1):
        if time in attacks_dict:
            success = 0
            cur_health -= attacks_dict[time]
        else:
            success += 1
            if cur_health < health:
                if success == bandage[0]:
                    success = 0
                    cur_health += (bandage[1] + bandage[2])
                else:
                    cur_health += bandage[1]
        if cur_health > health:
            cur_health = health
        if cur_health <= 0:
            return -1
    return cur_health