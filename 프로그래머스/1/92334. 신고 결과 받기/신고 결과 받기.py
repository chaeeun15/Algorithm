def solution(id_list, report, k):
    # 신고당한 횟수를 나타내는 dict
    reported_dict = {}
    # 신고한 사람: [신고당한 사람 1, ...]
    report_dict = {}
    mail_num = [0] * len(id_list)
    
    for report_str in set(report):
        a, b = report_str.split()
        if b not in reported_dict:
            reported_dict[b] = 1
        else:
            reported_dict[b] += 1
        if a not in report_dict:
            report_dict[a] = [b]
        else:
            report_dict[a] += [b]
        
    for report_user, reported_user in report_dict.items():
        for i in range(len(reported_user)):
            if reported_dict[reported_user[i]] >= k:
                mail_num[id_list.index(report_user)] += 1
    return mail_num