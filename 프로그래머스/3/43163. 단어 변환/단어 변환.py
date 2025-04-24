from collections import deque
def solution(begin, target, words):
    words_dict = {}
    words_len = len(begin)
    words.insert(0, begin)
    # 이동할 수 있는 단어들 dictionary로 저장
    for cur_idx, cur_word in enumerate(words):
        for next_idx, next_word in enumerate(words):
            cnt = 0
            if cur_word != next_word:
                for i in range(words_len):
                    if cur_word[i] != next_word[i]:
                        cnt += 1
                if cnt == 1:
                    if cur_word not in words_dict:
                        words_dict[cur_word] = [next_word]
                    else:
                        words_dict[cur_word] += [next_word]
    visit = [0] * len(words)
    queue = deque()
    # 시작 값인 begin과, 변경한 횟수인 cnt값을 queue에 넣어줌
    queue.append((begin, 0))
    while queue:
        cur, cnt = queue.popleft()
        if cur == target:
            return cnt
        visit[words.index(cur)] = 1
        for i in words_dict.get(cur, []):
            if visit[words.index(i)] == 0:
                queue.append((i, cnt+1))
    return 0