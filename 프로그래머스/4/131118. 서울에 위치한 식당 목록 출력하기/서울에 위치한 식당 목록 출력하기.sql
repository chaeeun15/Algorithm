SELECT rr.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, ROUND(AVG(rr.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO ri
JOIN REST_REVIEW rr ON ri.REST_ID = rr.REST_ID
WHERE ri.ADDRESS LIKE '서울%'
GROUP BY rr.REST_ID
ORDER BY SCORE DESC, ri.FAVORITES DESC;