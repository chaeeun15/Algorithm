SELECT ID, 
(CASE
 WHEN SIZE_RANK = 1 THEN 'CRITICAL'
 WHEN SIZE_RANK = 2 THEN 'HIGH'
 WHEN SIZE_RANK = 3 THEN 'MEDIUM'
 WHEN SIZE_RANK = 4 THEN 'LOW'
 END) AS COLONY_NAME
FROM (
    SELECT ID, NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS SIZE_RANK
    FROM ECOLI_DATA) AS SIZETABLE
ORDER BY ID;