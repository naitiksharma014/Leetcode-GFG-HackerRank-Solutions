# Count Subarrays Where Max Element Appears at Least K Times

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` and a  **positive**  integer `k`.

Return  *the number of subarrays where the  **maximum**  element of* `nums` *appears  **at least*** `k` *times in that subarray.* 

A  **subarray**  is a contiguous sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].

```

 **Example 2:** 

```
Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 106
- 1 <= k <= 105

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 89.26%)  
**Memory:** 109.2 MB (beats 75.34%)  
**Submitted:** 2026-10-30T10:15:59.965Z  

```java
// TC: O(n)

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        long maxNum = Integer.MIN_VALUE;
        for(int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        int i = 0, j = 0;
        int count = 0;
        long ans = 0;

        while(j < n) {

            int curr = nums[j];
            if(curr == maxNum) {
                count++;
            }

            while(count >= k) {

                ans += (n - j);

                int prev = nums[i];
                if(prev == maxNum) {
                    count--;
                }

                i++;
            }
            
            j++;
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/)