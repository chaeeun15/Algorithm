import sys
input = sys.stdin.readline

# n은 수열의 길이, s는 만들어야 하는 부분합
n, s = map(int, input().split())
# arr는 수열
arr = list(map(int, input().split()))

# length는 만들 수 있는 길이들을 담은 배열
length = []
# 한 개의 숫자로 s를 넘을 수 있는 경우
if max(arr) >= s:
    print(1)
else:
    first = 0
    second = 1
    # cur_sum은 부분합
    cur_sum = sum(arr[first:second+1])
    while second != n:
        if cur_sum >= s:
            length.append(second - first + 1)
            if (second - first + 1) == 2:
                break
            cur_sum -= arr[first]
            first += 1
        else:
            second += 1
            if second < n:
                cur_sum += arr[second]
    print(min(length) if length else 0)