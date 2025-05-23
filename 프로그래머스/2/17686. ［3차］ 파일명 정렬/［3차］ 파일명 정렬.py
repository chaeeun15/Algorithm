def solution(files):
    answer = []
    # key: file 이름, value: [HEAD, NUMBER]
    file_dict = {}
    for file in files:
        file_dict[file] = ['', '']
        for s in file:
            if s.isdigit() and len(file_dict[file][1]) < 5:
                file_dict[file][1] += s
            else:
                if file_dict[file][1] == '':
                    file_dict[file][0] += s.lower()
                else:
                    break
        file_dict[file][1] = int(file_dict[file][1])
    answer = sorted(file_dict.keys(), key = lambda x: (file_dict[x][0], file_dict[x][1]))
    return answer