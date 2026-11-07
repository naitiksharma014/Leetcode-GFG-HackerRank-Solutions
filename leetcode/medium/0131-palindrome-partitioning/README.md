# Palindrome Partitioning

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, partition `s` such that every substring of the partition is a  **palindrome**. Return  *all possible palindrome partitioning of* `s`.

 

 **Example 1:** 

```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

```

 **Example 2:** 

```
Input: s = "a"
Output: [["a"]]

```

 

 **Constraints:** 

- 1 <= s.length <= 16
- s contains only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 25.97%)  
**Memory:** 64.7 MB (beats 84.63%)  
**Submitted:** 2026-11-07T07:49:57.801Z  

```java
// TC = O(n · 2ⁿ) × O(n) = O(n² · 2ⁿ)​
// Auxiliary Space: O(n) for recursion and the current partition, excluding output.

class Solution {
    int n;
    List<String> currList = new ArrayList<>();
    List<List<String>> resultList = new ArrayList<>();

    public boolean isPalindrom(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {

            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public void solve(int idx, String s) {
        if(idx == n) {
            resultList.add(new ArrayList<>(currList));
        }

        for(int i = idx; i < n; i++) {

            if(isPalindrom(s.substring(idx, i + 1))) {

                currList.add(s.substring(idx, i + 1));

                solve(i + 1, s);

                currList.remove(currList.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        
        solve(0, s);

        return resultList;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-partitioning/)