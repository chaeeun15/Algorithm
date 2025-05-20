import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input()) # n은 전체 카드의 개수
k = int(input()) # k는 선택할 카드의 개수

answer = 0
card_dict = {}
card_list = []
for _ in range(n):
    card_list.append(int(input()))

for perm in permutations(card_list, k):
    cards = int(''.join(map(str, list(perm))))
    card_dict[cards] = 1
print(len(card_dict))