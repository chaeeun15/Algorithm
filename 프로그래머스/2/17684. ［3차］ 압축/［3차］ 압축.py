def solution(msg):
    answer = []
    dictionary = {'A': 1, 'B': 2, 'C': 3, 'D': 4, 'E': 5, 'F': 6, 'G': 7, 'H': 8, 'I': 9, 'J': 10, 'K': 11, 'L': 12, 'M': 13, 'N': 14, 'O': 15, 'P': 16, 'Q': 17, 'R': 18, 'S': 19, 'T': 20, 'U': 21, 'V': 22, 'W': 23, 'X': 24, 'Y': 25, 'Z': 26}
    pre = ''
    temp = ''
    alpha = 26
    idx = 0
    while idx < len(msg):
        pre += msg[idx]
        temp = pre
        i = 0
        while temp in dictionary:
            temp += msg[idx+i+1:idx+i+2]
            if temp not in dictionary or idx + i == len(msg) - 1:
                answer.append(dictionary[pre])
                break
            i += 1
            pre = temp
        alpha += 1
        dictionary[temp] = alpha
        idx += len(pre)
        pre = ''
    return answer