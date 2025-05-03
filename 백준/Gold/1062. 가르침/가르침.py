import sys
from itertools import combinations
input = sys.stdin.readline
# n은 단어의 개수, k는 배우는 글자의 개수
n, k = map(int, input().split())
answer = 0
word_list = []
for i in range(n):
    word_list.append(input().strip())
# anta, tica, 겹치는 문자 뺀 단어 리스트
word_sub = ['' for _ in range(n)]
for i in range(n):
    for j in word_list[i][4:-4]:
        if j not in {'a', 'n', 't', 'i', 'c'} and j not in word_sub[i]:
            word_sub[i] += j
# 알파벳만 따로 모음
chars = set(''.join(word_sub))
# anta, tica를 만들지 못하면 아무 단어도 읽을 수 없음
if k < 5:
    print(0)
# a,n,t,i,c 만으로 모든 글자를 만들 수 있는 경우
# if len(chars) == 0:
#     print(n)
# k-5개의 글자로 나머지를 다 표현할 수 있는 경우우
elif len(chars) <= k-5:
    print(n)
# anta, tica에 들어가는 antic 빼고 나머지 글자만 고려
else:
    for comb in combinations(chars, k-5):
        allowed = set(comb)
        count = 0
        for word in word_sub:
            if set(word).issubset(allowed):
                count += 1
        answer = max(answer, count)
    print(answer)