/*
Enter your query here.
*/
SELECT CONCAT(Name, '(' , SUBSTRING(OCCUPATION, 1, 1), ')')
FROM OCCUPATIONS
ORDER BY Name;

SELECT CONCAT(
    'There are a total of ',
    COUNT(*),
    ' ',
    LOWER(OCCUPATION),
    's.'
)
FROM OCCUPATIONS
GROUP BY OCCUPATION
ORDER BY COUNT(*), OCCUPATION;
