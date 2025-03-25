def solution(wallpaper):
    answer = [len(wallpaper), len(wallpaper[0]), 0, 0]
    for idx, str in enumerate(wallpaper):
        if "#" in str:
            answer[0] = min(idx, answer[0])
            answer[2] = max(idx+1, answer[2])
            answer[1] = min(str.find("#"), answer[1])
            answer[3] = max(str.rfind("#")+1, answer[3])
    return answer