SELECT *
FROM (
    SELECT DATETIME AS "시간"
    FROM ANIMAL_INS
    ORDER BY DATETIME ASC
)
WHERE ROWNUM <= 1