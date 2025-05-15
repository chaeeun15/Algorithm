import sys
input = sys.stdin.readline

# v는 정점의 개수, e는 간선의 개수
v, e = map(int, input().split())
# arr는 각 간선에 대한 정보
arr = []
for _ in range(e):
    arr.append(list(map(int, input().split())))
# cost값이 작은 순서대로 정렬
arr.sort(key = lambda x: x[2])

parent = [i for i in range(v+1)]
def find_parent(x):
    while parent[x] != x:
        parent[x] = parent[parent[x]]
        x = parent[x]
    return x

def union_parent(a, b):
    parent_a = find_parent(a)
    parent_b = find_parent(b)
    # 값이 큰 쪽의 루트 노드를 변경해야 함함
    if parent_a > parent_b:
        parent[parent_a] = parent_b
    else:
        parent[parent_b] = parent_a

def same_parent(a, b):
    # 두 노드의 루트 노드가 같으면 true 리턴
    return find_parent(a) == find_parent(b)

answer = 0
for a, b, cost in arr:
    # a, b의 루트 노드가 서로 다른 경우에만 추가
    if not same_parent(a, b):
        union_parent(a, b)
        answer += cost
print(answer)