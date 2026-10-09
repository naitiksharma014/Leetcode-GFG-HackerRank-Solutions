# population-density-difference

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Query the difference between the maximum and minimum populations in **CITY**.


**Input Format**

The **CITY** table is described as follows:
<img src="https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg" title="CITY.jpg" />

**Constraints**

 

**Output Format**

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T12:00:54.484Z  

```sql
SELECT SUM(POPULATION)
FROM CITY
WHERE COUNTRYCODE = 'JPN';

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/population-density-difference/problem)