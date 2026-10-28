# Subarray Product Less Than K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of integers `nums` and an integer `k`.

Return the number of contiguous subarrays where the  **product**  of all the elements in the  **subarray**  is  **strictly less**  than `k`.

 

 **Example 1:** 

```
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

```

 **Example 2:** 

```
Input: nums = [1,2,3], k = 0
Output: 0

```

 

 **Constraints:** 

- 1 <= nums.length <= 3 * 104
- 1 <= nums[i] <= 1000
- 0 <= k <= 106

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 44.81%)  
**Memory:** 48.8 MB (beats 71.13%)  
**Submitted:** 2026-10-28T17:19:11.179Z  

```java
// TC: O(n)
// SC: O(1)

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        
        int n = nums.length;

        int product = 1;
        int i = 0, j = 0;
        int ans = 0;

        while(j < n) {

            product *= nums[j];

            while(product >= k) {

                product /= nums[i];
                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarray-product-less-than-k/)