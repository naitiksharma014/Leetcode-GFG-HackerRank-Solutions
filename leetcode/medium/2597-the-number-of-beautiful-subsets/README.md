# The Number of Beautiful Subsets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array `nums` of positive integers and a  **positive**  integer `k`.

A subset of `nums` is  **beautiful**  if it does not contain two integers with an absolute difference equal to `k`.

Return  *the number of  **non-empty beautiful** subsets of the array*  `nums`.

A  **subset**  of `nums` is an array that can be obtained by deleting some (possibly none) elements from `nums`. Two subsets are different if and only if the chosen indices to delete are different.

 

Original
Java
 **Example 1:** 

```
Input: nums = [2,4,6], k = 2
Output: 4
Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
It can be proved that there are only 4 beautiful subsets in the array [2,4,6].

```

 **Example 2:** 

```
Input: nums = [1], k = 1
Output: 1
Explanation: The beautiful subset of the array nums is [1].
It can be proved that there is only 1 beautiful subset in the array [1].

```

 

 **Constraints:** 

- 1 <= nums.length <= 18
- 1 <= nums[i], k <= 1000

## Solution

**Language:** Java  
**Runtime:** 281 ms (beats 57.29%)  
**Memory:** 46.1 MB (beats 90.95%)  
**Submitted:** 2026-11-17T08:15:49.410Z  

```java
// Time Complexity: O(n * 2ⁿ)
// Space Complexity: O(n)

class Solution {
    int n;
    int result = 0;

    public void solve(int idx, int[] nums, int k, List<Integer> list) {
        if(idx >= n) {
            result++;
            return;
        }

        // Skip
        solve(idx + 1, nums, k, list);

        // Take
        boolean isPresent = true;

        for(int num: list) {

            if(Math.abs(num - nums[idx]) == k) {
                isPresent = false;
                break;
            }
        }

        if(isPresent) {

            list.add(nums[idx]);

            solve(idx + 1, nums, k, list);

            list.remove(list.size() - 1);
        }
    }

    public int beautifulSubsets(int[] nums, int k) {
        n = nums.length;
        
        solve(0, nums, k, new ArrayList<>());

        return result - 1;  // Remove empty subset
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/the-number-of-beautiful-subsets/)