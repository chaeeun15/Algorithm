import sys
input = sys.stdin.readline

word = input().strip()
dict = {}

for w in word:
    if w.upper() not in dict:
        dict[w.upper()] = 1
    else:
        dict[w.upper()] += 1

dict_s = sorted(dict.items(), key = lambda x: x[1], reverse = True)
maximum = dict_s[0][1]
answer = dict_s[0][0]

if len(dict_s) > 1 and dict_s[1][1] == maximum:
    print('?')
else:
    print(answer)