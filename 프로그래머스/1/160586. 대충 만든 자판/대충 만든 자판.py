def solution(keymap, targets):
    answer = [0] * len(targets)
    key_dict = {}
    
    # key, 가장 빠른 순서로 dict 만듦
    for key in keymap:
        for k in key:
            key_dict[k] = min(key.find(k)+1, key_dict.get(k, len(key)))
    
    for idx, target in enumerate(targets):
        for t in target:
            if t in key_dict:
                answer[idx] += key_dict.get(t)
            else:
                answer[idx] = -1
                break
    return answer