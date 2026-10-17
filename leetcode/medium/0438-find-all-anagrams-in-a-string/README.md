# Find All Anagrams in a String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings `s` and `p`, return an array of all the start indices of `p`'s anagrams in `s`. You may return the answer in  **any order**.

 

 **Example 1:** 

```
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

```

 **Example 2:** 

```
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

```

 

 **Constraints:** 

- 1 <= s.length, p.length <= 3 * 104
- s and p consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 91.44%)  
**Memory:** 46.7 MB (beats 69.80%)  
**Submitted:** 2026-10-17T16:48:08.647Z  

```java
// TC: O(n)

class Solution {
    public boolean allZero(int[] freq) {

        for(int f: freq) {
            if(f != 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[] freq = new int[26];
        for(char ch: p.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while(j < m) {

            char ch = s.charAt(j);
            freq[ch - 'a']--;

            if(j - i + 1 == n) {

                if(allZero(freq)) {
                    list.add(i);
                }

                char prevCh = s.charAt(i);
                freq[prevCh - 'a']++;
                i++;
            }

            j++;
        }

        return list;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-all-anagrams-in-a-string/)