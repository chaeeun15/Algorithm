import sys
input = sys.stdin.readline

# t는 테스트 케이스의 개수
t = int(input())
for _ in range(t):
    # n은 트리를 구성하는 노드의 수
    n = int(input())
    # parent는 각 노드의 부모 노드를 저장한 리스트
    parent = [0] * (n+1)
    for i in range(n-1):
        # a는 b의 부모 노드
        a, b = map(int, input().split())
        parent[b] = a
    # node1과 node2의 가장 가까운 공통 조상을 구해야 함
    node1, node2 = map(int, input().split())
    
    # node1, node2가 서로 부모, 자식 관계인 경우를 대비해서 맨 앞에 0 추가
    node1_p, node2_p = [0, node1], [0, node2]
    while parent[node1]:
        node1_p.append(parent[node1])
        node1 = parent[node1]
    while parent[node2]:
        node2_p.append(parent[node2])
        node2 = parent[node2]

    # 맨 뒤에서부터 한 칸씩 앞으로 이동하면서 가장 가까운 공통 조상 구함
    i = 1
    while node1_p[-i] == node2_p[-i]:
        i += 1
    print(node1_p[-i+1])