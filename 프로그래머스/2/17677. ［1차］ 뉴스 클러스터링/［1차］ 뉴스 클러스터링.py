import math
def solution(str1, str2):
    answer = 0
    str1 = str1.lower()
    str2 = str2.lower()
    str1_list = []
    str2_list = []
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha() and len(str1[i:i+2]) == 2:
            str1_list.append(str1[i:i+2])
    for j in range(len(str2)-1):
        if str2[j:j+2].isalpha() and len(str2[j:j+2]) == 2:
            str2_list.append(str2[j:j+2])
    combine = len(str2_list)
    inter = 0
    for string in str1_list:
        if string in str2_list:
            inter += 1
            str2_list.remove(string)
        else:
            combine += 1
    if combine == 0:
        return 65536
    return math.floor(inter/combine*65536)