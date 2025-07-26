import sys
input = sys.stdin.readline

# n은 단어 개수, k는 가르친 글자의 개수
n, k = map(int, input().split())
words = []
for _ in range(n):
    words.append(set(input().strip()))

# a, n, t, i, c은 무조건 읽어야 하므로
# k가 5 미만이면 읽을 수 있는 단어 없음
if k < 5:
    print(0)
    exit(0)
# k가 26이면 모든 글자를 다 읽을 수 있음
elif k == 26:
    print(n)
    exit(0)

# a, n, t, i, c는 visit을 True로 설정
visit = [False] * 26
for c in ('a', 'n', 't', 'i', 'c'):
    visit[ord(c) - ord('a')] = True

def dfs(start, cnt):
    global ans
    # antic외에 visit이 True로 바뀐 알파벳이 k-5개가 되면
    if cnt == k - 5:
        temp = 0
        # words리스트를 돌면서 각 단어가 지금 True인 알파벳들로 읽을 수 있는지 확인
        for word in words:
            readable = True
            for c in word:
                if not visit[ord(c) - ord('a')]:
                    readable = False
                    break
            if readable:
                temp += 1
        ans = max(ans, temp)
        return

    for i in range(start, 26):
        if not visit[i]:
            # antic 이외에 다른 알파벳들을 하나씩 True로 바꿔가면서 dfs 실행
            visit[i] = True
            dfs(i, cnt + 1)
            # 예를 들어 k = 8이면 b, d, (e~z)로 dfs를 돌고
            # b, e, (f~z)로 dfs를 돌고, 모든 경우의 수를 확인해볼 수 있음. 
            visit[i] = False

ans = 0
dfs(0, 0)
print(ans)