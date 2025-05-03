import sys
input = sys.stdin.readline

# n은 멀티탭 구멍의 수, k는 전기 용품 총 사용 횟수
n, k = map(int, input().split())
# arr는 전기용품의 사용 순서
arr = list(map(int, input().split()))

answer = 0
# multi는 지금 멀티탭을 사용중인 전기 용품 리스트트
multi = []
for idx, i in enumerate(arr):
    if i in multi:
        continue
    if len(multi) < n:
        multi.append(i)
    else:
        if i in multi:
            continue
        else:
            # 최대한 뒤에 사용되는 전기용품을 빼야 함
            # back은 지금 사용중인 전기용품이 뒤의 어느 위치에서 사용되는지를 담은 리스트
            back = []
            for elect in multi:
                if elect in arr[idx:]:
                    back.append(arr[idx:].index(elect))
                else:
                    back.append(k+1)
            multi[back.index(max(back))] = i
            answer += 1
print(answer)