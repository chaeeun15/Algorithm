def solution(survey, choices):
    answer = ''
    type_dict = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}
    for idx, type in enumerate(survey):
        if choices[idx] // 4 == 0:
            type_dict[type[0]] += 4-choices[idx]
        elif choices[idx] // 4 == 1:
            type_dict[type[1]] += 1*choices[idx]%4
        
    if type_dict["R"] >= type_dict["T"]:
        answer += "R"
    else:
        answer += "T"
    if type_dict["C"] >= type_dict["F"]:
        answer += "C"
    else:
        answer += "F"
    if type_dict["J"] >= type_dict["M"]:
        answer += "J"
    else:
        answer += "M"
    if type_dict["A"] >= type_dict["N"]:
        answer += "A"
    else:
        answer += "N"
    return answer