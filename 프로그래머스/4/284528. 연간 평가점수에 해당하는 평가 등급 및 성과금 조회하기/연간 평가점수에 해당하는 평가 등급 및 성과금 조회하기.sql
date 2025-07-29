SELECT hg.EMP_NO, he.EMP_NAME, hg.GRADE, he.SAL * hg.BONUS * 0.01 AS BONUS
FROM HR_EMPLOYEES he
JOIN HR_DEPARTMENT hd ON he.DEPT_ID = hd.DEPT_ID
JOIN 
(
    SELECT EMP_NO, AVG(SCORE) AS SCORE,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 20
            WHEN AVG(SCORE) >= 90 THEN 15
            WHEN AVG(SCORE) >= 80 THEN 10
            ELSE 0
        END AS BONUS
    FROM HR_GRADE
    GROUP BY EMP_NO
) hg ON he.EMP_NO = hg.EMP_NO
ORDER BY EMP_NO;