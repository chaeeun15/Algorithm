SELECT ed.ID, ed.GENOTYPE, ed2.GENOTYPE AS 'PARENT_GENOTYPE'
FROM ECOLI_DATA ed
JOIN ECOLI_DATA ed2 ON ed.PARENT_ID = ed2.ID
WHERE ed.GENOTYPE & ed2.GENOTYPE = ed2.GENOTYPE
ORDER BY ed.ID ASC;