# Permutations

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in  **any order**.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

```

 **Example 2:** 

```
Input: nums = [0,1]
Output: [[0,1],[1,0]]

```

 **Example 3:** 

```
Input: nums = [1]
Output: [[1]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 6
- -10 <= nums[i] <= 10
- All the integers of nums are unique.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 8.43%)  
**Memory:** 45.1 MB (beats 67.15%)  
**Submitted:** 2026-11-13T08:02:03.765Z  

```java
// TC: O(N * N!)
// SC: O(N) auxiliary, excluding output.

class Solution {
    int n;
    Set<Integer> set = new HashSet();
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public void solve(int[] nums){
        
        if(currList.size() == n) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for(int i = 0; i < n; i++) {

            if(set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            currList.add(nums[i]);

            solve(nums);

            set.remove(nums[i]);
            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        solve(nums);
        return resultList;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/permutations/)