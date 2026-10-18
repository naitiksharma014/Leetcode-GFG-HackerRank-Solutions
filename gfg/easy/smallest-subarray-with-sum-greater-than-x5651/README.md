# Smallest Subarray Sum Greater Than x

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a number  **x** and an array of integers  **arr**, find the smallest subarray with sum strictly greater than the given value. If such a subarray do not exist return 0 in that case.

 **Examples:** 

```
Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: Minimum length subarray is [4, 45, 6]
```

```
Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray exist
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-18T15:22:51.397Z  

```java
class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        // code here
        int n = arr.length;
        
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        
        while(j < n) {
            
            sum += arr[j];
            
            while(sum > x) {
                
                minLen = Math.min(minLen, j - i + 1);
                sum -= arr[i];
                i++;
            }
            
            j++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1)