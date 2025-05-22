def solution(records):
    answer = []
    id_nick = {}
    id_cnt = {}
    idx = 0
    for record in records:
        command = record.split()[0]
        if command == 'Enter':
            userId = record.split()[1]
            nickName = record.split()[2]
            # 이전에 들어온 적 있는 사람이고, 닉네임이 변경되었으면
            if userId in id_nick and nickName != id_nick[userId]:
                # 기록 확인해서 이전 기록 수정
                for i in id_cnt[userId]:
                    nim = answer[i].find("님")
                    answer[i] = nickName + answer[i][nim:]
            id_nick[userId] = nickName
            answer.append(nickName + "님이 들어왔습니다.")
            # 들어온 타이밍 기록
            if userId in id_cnt:
                id_cnt[userId] += [idx]
            else:
                id_cnt[userId] = [idx]
            idx += 1
        elif command == 'Leave':
            userId = record.split()[1]
            answer.append(id_nick[userId] + "님이 나갔습니다.")
            # 나간 타이밍 기록
            id_cnt[userId] += [idx]
            idx += 1
        elif command == 'Change':
            userId = record.split()[1]
            nickName = record.split()[2]
            # 이전 기록 확인해서 닉네임 변경
            for j in id_cnt[userId]:
                nim = answer[j].find("님")
                answer[j] = nickName + answer[j][nim:]
            id_nick[userId] = nickName
    return answer