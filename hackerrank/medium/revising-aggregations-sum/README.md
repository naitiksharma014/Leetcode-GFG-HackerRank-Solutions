# Revising Aggregations - The Sum Function

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Query the total population of all cities in **CITY** where *District* is **California**. 

**Input Format**

The **CITY** table is described as follows:
<img src="https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg" title="CITY.jpg" />

**Output Format**

## Solution

**Language:** db2  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T15:34:03.190Z  

```db2

/*
    Enter your query here and follow these instructions:
    1. Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
    2. The AS keyword causes errors, so follow this convention: "Select t.Field From table1 t" instead of "select t.Field From table1 AS t"
    3. Type your code immediately after comment. Don't leave any blank line.
*/
SELECT SUM(POPULATION)
FROM CITY
WHERE DISTRICT = 'California';

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/revising-aggregations-sum/problem)