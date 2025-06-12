import sys
input = sys.stdin.readline

# t는 테스트 케이스의 개수
t = int(input())

for _ in range(t):
    list_ = list(map(int, input().split()))
    list_.sort(reverse = True)
    print(list_[2])