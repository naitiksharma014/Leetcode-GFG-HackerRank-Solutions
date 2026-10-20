# Contains Duplicate II

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums` and an integer `k`, return `true`  *if there are two  **distinct indices*** `i` *and* `j` *in the array such that* `nums[i] == nums[j]` *and* `abs(i - j) <= k`.

 

 **Example 1:** 

```
Input: nums = [1,2,3,1], k = 3
Output: true

```

 **Example 2:** 

```
Input: nums = [1,0,1,1], k = 1
Output: true

```

 **Example 3:** 

```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109
- 0 <= k <= 105

## Solution

**Language:** Java  
**Runtime:** 34 ms (beats 21.38%)  
**Memory:** 104.2 MB (beats 98.91%)  
**Submitted:** 2026-10-20T15:07:29.701Z  

```java
// Sliding Window
// TC: O(n)
// Sc: O(n)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();

        while(j < n) {

            if(Math.abs(i - j) > k) {

                int prevNum = nums[i];
                set.remove(prevNum);
                i++;
            }

            int currNum = nums[j];
            if(set.contains(currNum)) {
                return true;
            }

            set.add(currNum);
            j++;
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/contains-duplicate-ii/)