import sys
from collections import Counter
input = sys.stdin.readline

# g는 단어의 길이, slen은 문자열 s의 길이
g, slen = map(int, input().split())
# w는 찾고자 하는 단어
w = input().strip()
# s는 벽화에서 추출한 문자열
s = input().strip()
answer = 0

w_cnt = Counter(w)
temp_cnt = Counter(s[:g])
if temp_cnt == w_cnt:
    answer += 1
for i in range(g, slen):
    if s[i] not in temp_cnt:
        temp_cnt[s[i]] = 1
    else:
        temp_cnt[s[i]] += 1
    temp_cnt[s[i-g]] -= 1
    if temp_cnt == w_cnt:
        answer += 1
print(answer)