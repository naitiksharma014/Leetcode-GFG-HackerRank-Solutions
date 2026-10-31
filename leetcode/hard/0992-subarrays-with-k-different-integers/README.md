# Subarrays with K Different Integers

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums` and an integer `k`, return  *the number of  **good subarrays**  of* `nums`.

A  **good array**  is an array where the number of different integers in that array is exactly `k`.

- For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.

A  **subarray**  is a  **contiguous**  part of an array.

 

 **Example 1:** 

```
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

```

 **Example 2:** 

```
Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 104
- 1 <= nums[i], k <= nums.length

## Solution

**Language:** Java  
**Runtime:** 56 ms (beats 5.14%)  
**Memory:** 49.7 MB (beats 70.48%)  
**Submitted:** 2026-10-31T16:17:24.330Z  

```java
// TC: O(n)
// SC: O(K)

class Solution {
    public int slidingWindow(int[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(j < n){

            int curr = nums[j];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.size() > k) {

                int prev = nums[i];
                map.put(prev, map.get(prev) - 1);

                if(map.get(prev) == 0) {
                    map.remove(prev);
                }

                i++;
            }

            count += (j - i + 1);
            j++;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly K distinct → AtMost(K) - AtMost(K-1)

        int AtMost_K = slidingWindow(nums, k);
        int AtMost_K_minus_1 = slidingWindow(nums, k - 1);
        int Exactly_K_distinct =  AtMost_K - AtMost_K_minus_1;

        return Exactly_K_distinct;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarrays-with-k-different-integers/)