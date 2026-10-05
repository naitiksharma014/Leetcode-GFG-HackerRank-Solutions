# Employee Salaries

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Write a query that prints a list of employee names (i.e.: the *name* attribute) for employees in **Employee** having a salary greater than $\$2000$ per month who have been employees for less than $10$ months. Sort your result by ascending _employee\_id_.

**Input Format**

The **Employee** table containing employee data for a company is described as follows: 

<img src="https://s3.amazonaws.com/hr-challenge-images/19629/1458557872-4396838885-ScreenShot2016-03-21at4.27.13PM.png"/>

where _employee\_id_ is an employee's ID number, _name_ is their name, _months_ is the total number of months they've been working for the company, and _salary_ is the their monthly salary.

**Constraints**

 

**Output Format**

## Solution

**Language:** db2  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T15:25:25.524Z  

```db2

/*
    Enter your query here and follow these instructions:
    1. Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
    2. The AS keyword causes errors, so follow this convention: "Select t.Field From table1 t" instead of "select t.Field From table1 AS t"
    3. Type your code immediately after comment. Don't leave any blank line.
*/
SELECT name
FROM Employee

WHERE salary > 2000 AND months < 10
ORDER BY employee_id;

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/salary-of-employees/problem)