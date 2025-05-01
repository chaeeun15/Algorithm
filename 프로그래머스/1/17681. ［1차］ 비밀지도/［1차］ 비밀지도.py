def solution(n, arr1, arr2):
    answer = ["" for i in range(n)]
    for i in range(n):
        # arr1 지도 해독
        num1 = arr1[i]
        row1 = ""
        while num1 > 0:
            if num1 % 2 == 0:
                row1 += " "
            else:
                row1 += "#"
            num1 //= 2
        if len(row1) < n:
            row1 += " " * (n-len(row1))
        row1 = row1[::-1]
        
        # arr2 지도 해독
        num2 = arr2[i]
        row2 = ""
        while num2 > 0:
            if num2 % 2 == 0:
                row2 += " "
            else:
                row2 += "#"
            num2 //= 2
        if len(row2) < n:
            row2 += " " * (n-len(row2))
        row2 = row2[::-1]
    
        # arr1, arr2 합치기
        for r in range(len(row2)):
            if row1[r] == row2[r] == " ":
                answer[i] += " "
            else:
                answer[i] += "#"
    return answer