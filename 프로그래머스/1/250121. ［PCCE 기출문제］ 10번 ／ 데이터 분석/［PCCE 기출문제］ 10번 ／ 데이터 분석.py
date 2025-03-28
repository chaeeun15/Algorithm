def solution(data, ext, val_ext, sort_by):
    answer = []
    for code, date, maximum, remain in data:
        if ext == "code":
            if code <= val_ext:
                answer.append([code, date, maximum, remain])
        elif ext == "date":
            if date <= val_ext:
                answer.append([code, date, maximum, remain])
        elif ext == "maximum":
            if maximum <= val_ext:
                answer.append([code, date, maximum, remain])
        elif ext == "remain":
            if remain <= val_ext:
                answer.append([code, date, maximum, remain])
        
        if sort_by == "code":
            answer.sort(key=lambda x:x[0])
        elif sort_by == "date":
            answer.sort(key=lambda x:x[1])
        elif sort_by == "maximum":
            answer.sort(key=lambda x:x[2])
        elif sort_by == "remain":
            answer.sort(key=lambda x:x[3])
    return answer