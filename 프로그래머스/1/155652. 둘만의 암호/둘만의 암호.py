def solution(s, skip, index):
    answer = ''

    # 사용 가능한 알파벳 리스트 생성
    alphabets = [chr(i) for i in range(ord('a'), ord('z') + 1)]  # 알파벳 a-z
    available = [char for char in alphabets if char not in skip]  # skip 제외

    # 각 문자 변환
    for char in s:
        current_pos = available.index(char)  # 현재 문자 위치
        new_pos = (current_pos + index) % len(available)  # index 만큼 이동 후 순환 처리
        answer += available[new_pos]  # 변환된 문자 추가
    return answer