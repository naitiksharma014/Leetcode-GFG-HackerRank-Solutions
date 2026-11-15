# Combination Sum IV

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of  **distinct**  integers `nums` and a target integer `target`, return  *the number of possible combinations that add up to*  `target`.

The test cases are generated so that the answer can fit in a  **32-bit**  integer.

 

Original
Java
 **Example 1:** 

```
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

```

 **Example 2:** 

```
Input: nums = [9], target = 3
Output: 0

```

 

 **Constraints:** 

- 1 <= nums.length <= 200
- 1 <= nums[i] <= 1000
- All the elements of nums are unique.
- 1 <= target <= 1000

 

 **Follow up:**  What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 41.9 MB (beats 93.82%)  
**Submitted:** 2026-11-15T10:53:46.376Z  

```java
// TC: O(N * Target)
// SC: O(Target)

class Solution {
    int n;
    Integer[] dp = new Integer[1001];

    public int solve(int sum, int[] nums, int target) {
        if(sum > target) {
            return 0;
        }

        if(sum == target) {
            return 1;
        }

        if(dp[sum] != null) {
            return dp[sum];
        }

        int count = 0;

        for(int i = 0; i < n; i++) {

            sum += nums[i];
            
            count += solve(sum, nums, target);

            sum -= nums[i];
            
        }

        return dp[sum] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;

        return solve(0, nums, target);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/combination-sum-iv/)