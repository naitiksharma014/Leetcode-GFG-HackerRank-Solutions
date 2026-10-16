# Two Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of integers `nums` and an integer `target`, return  *indices of the two numbers such that they add up to `target`*.

You may assume that each input would have  ***exactly *one solution**, and you may not use the* same* element twice.

You can return the answer in any order.

 

 **Example 1:** 

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

```

 **Example 2:** 

```
Input: nums = [3,2,4], target = 6
Output: [1,2]

```

 **Example 3:** 

```
Input: nums = [3,3], target = 6
Output: [0,1]

```

 

 **Constraints:** 

- 2 <= nums.length <= 104
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- Only one valid answer exists.

 

 **Follow-up:** Can you come up with an algorithm that is less than `O(n2)` time complexity?

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 46.76%)  
**Memory:** 46 MB (beats 99.77%)  
**Submitted:** 2026-10-16T15:24:05.766Z  

```java
// TC: O(n)
// SC: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {

            int first = nums[i];
            int second = target - first;

            if(map.containsKey(second)) {
                ans[0] = i;
                ans[1] = map.get(second);
            }

            map.put(first, i);
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/two-sum/)