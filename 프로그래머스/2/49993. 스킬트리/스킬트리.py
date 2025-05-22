def solution(skills, skill_trees):
    answer = 0
    skill_dict = {}
    for i in range(len(skills)):
        skill_dict[skills[i]] = i
    for skilltree in skill_trees:
        pre_skill = 0
        for skill in skilltree:
            if skill in skill_dict:
                if skill_dict[skill] != pre_skill:
                    answer += 1
                    break
                pre_skill += 1
    return len(skill_trees) - answer