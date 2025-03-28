def solution(name, yearning, photos):
    answer = [0] * len(photos)
    name_dict = dict(zip(name, yearning))
    for idx, photo in enumerate(photos):
        for person in photo:
            if person in name_dict:
                answer[idx] += name_dict[person]
    return answer