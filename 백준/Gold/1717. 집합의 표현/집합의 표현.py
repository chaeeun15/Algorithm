# 최소 스패닝 트리에서 배운 서로소 집합 알고리즘
import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

# 집합은 총 n+1개, m은 입력으로 주어지는 연산의 개수
n, m = map(int, input().split())
# 처음에는 자기 자신을 부모 노드로 설정
parent = [i for i in range(n+1)]

def find_parent(x):
    if parent[x] == x:
        return x
    parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a > b:
        parent[a] = b
    else:
        parent[b] = a

for i in range(m):
    op, a, b = map(int, input().split())
    if op == 0:
        union_parent(a, b)
    elif op == 1:
        if find_parent(a) == find_parent(b):
            print("YES")
        else:
            print("NO")