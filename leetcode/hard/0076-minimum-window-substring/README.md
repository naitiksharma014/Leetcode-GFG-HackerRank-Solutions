# Minimum Window Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two strings `s` and `t` of lengths `m` and `n` respectively, return  *the  **minimum window***   ***substring**  **of  *`s`*  such that every character in  *`t`*  (** including duplicates**) is included in the window *. If there is no such substring, return* the empty string *`""`.

The testcases will be generated such that the answer is  **unique**.

 

 **Example 1:** 

```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

```

 **Example 2:** 

```
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

```

 **Example 3:** 

```
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

```

 

 **Constraints:** 

- m == s.length
- n == t.length
- 1 <= m, n <= 105
- s and t consist of uppercase and lowercase English letters.

 

 **Follow up:**  Could you find an algorithm that runs in `O(m + n)` time?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 99.70%)  
**Memory:** 44.8 MB (beats 98.97%)  
**Submitted:** 2026-10-19T13:31:28.710Z  

```java
// Sliding Window + Frequency Array
// TC: O(n + m)
// SC: O(128) ≈ O(1)

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m < n) {
            return "";
        }

        int[] freq = new int[128];
        for(char ch: t.toCharArray()) {
            freq[ch]++;
        }

        int minWindow = Integer.MAX_VALUE;
        int requiredCount = n;
        int i = 0, j = 0;
        int start = 0;

        while(j < m) {

            char ch = s.charAt(j);

            if(freq[ch] > 0) {      // Required wala
                requiredCount--;
            }

            freq[ch]--;

            while(requiredCount == 0) {

                int currWindow = j - i + 1;
                
                if(currWindow < minWindow) {
                    minWindow = currWindow;
                    start = i;
                }

                char prevChar = s.charAt(i);
                freq[prevChar]++;

                if(freq[prevChar] > 0) {
                   requiredCount++;
                }

                i++;
            }

            j++;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindow);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-window-substring/)