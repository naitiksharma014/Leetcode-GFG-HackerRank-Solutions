# Population Density Difference

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
**Submitted:** 2026-10-10T17:29:01.270Z  

```sql
SELECT 
(SELECT POPULATION FROM CITY ORDER BY POPULATION DESC LIMIT 1) 
- 
(SELECT POPULATION FROM CITY ORDER BY POPULATION LIMIT 1);

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/population-density-difference/problem)