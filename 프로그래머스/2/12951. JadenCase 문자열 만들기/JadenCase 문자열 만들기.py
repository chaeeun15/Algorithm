def solution(s):
    answer = ''
    slist = list(s.split(' '))
    word_list = []
    for i in slist:
        word = ''
        if len(i) >= 1:
            word = i[0].upper()
            if len(i) >= 2:
                word += i[1:].lower()
        word_list.append(word)
    return ' '.join(word_list)