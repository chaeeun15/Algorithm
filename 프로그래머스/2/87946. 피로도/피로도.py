from itertools import permutations
def solution(k, dungeons):
    number_of_dungeons = len(dungeons)
    answer = -1
    for dungeon in permutations(dungeons):
        avail_dungeon = 0
        cur_k = k
        for min, cost in dungeon:
            if cur_k >= min:
                cur_k -= cost
                avail_dungeon += 1
            answer = max(answer, avail_dungeon)
    return answer