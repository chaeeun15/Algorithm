SELECT *
FROM (
    SELECT DATETIME
    FROM ANIMAL_INS
    ORDER BY DATETIME DESC
)
WHERE ROWNUM <= 1