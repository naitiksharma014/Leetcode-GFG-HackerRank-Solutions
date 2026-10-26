# Different Ways to Add Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `expression` of numbers and operators, return  *all possible results from computing all the different possible ways to group numbers and operators*. You may return the answer in  **any order**.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed `104`.

 

 **Example 1:** 

```
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

```

 **Example 2:** 

```
Input: expression = "2 *3-4* 5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2 *(3-(4* 5))) = -34 
((2 *3)-(4* 5)) = -14 
((2 *(3-4))* 5) = -10 
(2 *((3-4)* 5)) = -10 
(((2 *3)-4)* 5) = 10

```

 

 **Constraints:** 

- 1 <= expression.length <= 20
- expression consists of digits and the operator '+', '-', and '*'.
- All the integer values in the input expression are in the range [0, 99].
- The integer values in the input expression do not have a leading '-' or '+' denoting the sign.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 57.56%)  
**Memory:** 44 MB (beats 67.06%)  
**Submitted:** 2026-10-26T11:02:34.324Z  

```java
//T.C : O(n*2^n)
//S.C : O(2^n) //The result vector stores all possible outcomes. The number of results is at most exponential in terms of the number of operators, so the space required to store the results is O(2^n).

class Solution {
    public List<Integer> solve(String expression) {
        int n = expression.length();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            char ch = expression.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*') {

                List<Integer> leftList = solve(expression.substring(0, i));
                List<Integer> rightList = solve(expression.substring(i + 1));

                for(int x: leftList) {
                    for(int y: rightList) {

                        if(ch == '+') {
                            result.add(x + y);
                        }
                        else if(ch == '-') {
                            result.add(x - y);
                        }
                        else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/different-ways-to-add-parentheses/)