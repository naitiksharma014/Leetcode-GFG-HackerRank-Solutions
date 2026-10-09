# revising-aggregations-the-average-function

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Query the average population of all cities in **CITY** where *District* is **California**. 




**Input Format**

The **CITY** table is described as follows:
<img src="https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg" title="CITY.jpg" />

**Output Format**

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T11:56:22.836Z  

```sql
SELECT AVG(POPULATION)
FROM CITY
WHERE DISTRICT = 'California';

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/revising-aggregations-the-average-function/problem)