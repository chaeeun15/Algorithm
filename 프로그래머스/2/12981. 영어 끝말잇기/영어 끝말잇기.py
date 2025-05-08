def solution(n, words):
    answer = [0, 0]
    pre_word_list = []
    pre_word = ''
    for idx, word in enumerate(words):
        if idx == 0:
            if (word in pre_word_list) or (len(word) == 1):
                answer = [idx%n+1, idx//n+1]
                break
        else:
            if (word in pre_word_list) or (len(word) == 1) or (word[0] != pre_word[-1]):
                answer = [idx%n+1, idx//n+1]
                break
        pre_word = word
        pre_word_list.append(word)
    return answer