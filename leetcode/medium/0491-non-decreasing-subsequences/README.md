# Non-decreasing Subsequences

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return  *all the different possible non-decreasing subsequences of the given array with at least two elements*. You may return the answer in  **any order**.

 

 **Example 1:** 

```
Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

```

 **Example 2:** 

```
Input: nums = [4,4,3,2,1]
Output: [[4,4]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 15
- -100 <= nums[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 18 ms (beats 21.01%)  
**Memory:** 51.8 MB (beats 96.47%)  
**Submitted:** 2026-11-06T16:06:06.647Z  

```java
// Time: (O(2^n * n) approximately.
// Auxiliary space: O(n), excluding output.

class Solution {
    int n;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void solve(int i, int prev, int[] nums) {
        if(i == n) {
            if(list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if(prev <= nums[i]) {

            list.add(nums[i]);

            solve(i + 1, nums[i], nums);

            list.remove(list.size() - 1);
        } 
        
        solve(i + 1, prev, nums);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;

        solve(0, Integer.MIN_VALUE, nums);

        res = new ArrayList<>(new LinkedHashSet<>(res));    // Removes Duplicate
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/non-decreasing-subsequences/)