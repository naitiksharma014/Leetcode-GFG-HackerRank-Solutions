# Revising Aggregations - The Count Function

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Query a *count* of the number of cities in **CITY** having a *Population* larger than $100,000$. 

**Input Format**

The **CITY** table is described as follows:
<img src="https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg" title="CITY.jpg" />

**Constraints**

 

**Output Format**

## Solution

**Language:** db2  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T15:31:20.845Z  

```db2

/*
    Enter your query here and follow these instructions:
    1. Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
    2. The AS keyword causes errors, so follow this convention: "Select t.Field From table1 t" instead of "select t.Field From table1 AS t"
    3. Type your code immediately after comment. Don't leave any blank line.
*/
SELECT COUNT(*)
FROM CITY
WHERE POPULATION > 100000;

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/revising-aggregations-the-count-function/problem)