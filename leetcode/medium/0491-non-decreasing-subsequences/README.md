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
**Runtime:** 8 ms (beats 49.24%)  
**Memory:** 52.3 MB (beats 85.46%)  
**Submitted:** 2026-11-06T16:28:15.784Z  

```java
// Time: (O(n * 2^n) upper bound.
// Auxiliary space: O(n), excluding output.

class Solution {
    int n;
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    

    public void solve(int i, int[] nums) {
        if(currList.size() > 1) {
            resultList.add(new ArrayList<>(currList));
        }

        HashSet<Integer> set = new HashSet<>();

        for(int j = i; j < n; j++) {

            if(set.contains(nums[j])) {
                continue;
            }
            
            if(currList.isEmpty() || currList.get(currList.size() - 1) <= nums[j]) {

                set.add(nums[j]);
                currList.add(nums[j]);

                solve(j + 1, nums);

                currList.remove(currList.size() - 1);
            }
        }

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;

        solve(0, nums);

        return resultList;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/non-decreasing-subsequences/)