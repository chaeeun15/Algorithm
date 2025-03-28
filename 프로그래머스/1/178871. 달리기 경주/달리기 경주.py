def solution(players, callings):
    players_dict = {player: rank for rank, player in enumerate(players)}
    players_dict_reverse = {rank: player for rank, player in enumerate(players)}
    for calling in callings:
        players_dict[players_dict_reverse[players_dict[calling] - 1]] += 1
        players_dict[calling] -= 1
        players_dict_reverse[players_dict[calling] + 1] = players_dict_reverse[players_dict[calling]]
        players_dict_reverse[players_dict[calling]] = calling
    return sorted(players_dict, key=lambda x: players_dict[x])