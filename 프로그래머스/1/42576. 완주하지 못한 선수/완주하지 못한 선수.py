from collections import Counter
def solution(participant, completion):
    pc = Counter(participant)
    cc = Counter(completion)
    return list((pc - cc).elements())[0]