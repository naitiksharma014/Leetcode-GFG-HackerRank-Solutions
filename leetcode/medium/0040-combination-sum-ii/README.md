# Combination Sum II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used  **once**  in the combination.

 **Note:**  The solution set must not contain duplicate combinations.

 

Original
Java
 **Example 1:** 

```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

```

 **Example 2:** 

```
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

```

 

 **Constraints:** 

- 1 <= candidates.length <= 100
- 1 <= candidates[i] <= 50
- 1 <= target <= 30

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 16.26%)  
**Memory:** 44.7 MB (beats 76.85%)  
**Submitted:** 2026-11-15T16:47:39.219Z  

```java
class Solution {
    int n;
    Set<Integer> set = new HashSet<>();
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public void solve(int idx, int sum, int[] candidates, int target) {
        if(sum == target) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        if(sum > target) {
            return;
        }

        for(int i = idx; i < n; i++) {
            
            if(i > idx && candidates[i] == candidates[i - 1]) {
    continue;
}

            currList.add(candidates[i]);

            solve(i + 1, sum + candidates[i], candidates, target);

            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);

        solve(0, 0, candidates, target);
        return resultList;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/combination-sum-ii/)