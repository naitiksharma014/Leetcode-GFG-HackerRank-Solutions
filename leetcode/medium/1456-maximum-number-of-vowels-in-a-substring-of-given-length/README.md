# Maximum Number of Vowels in a Substring of Given Length

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` and an integer `k`, return  *the maximum number of vowel letters in any substring of* `s` *with length* `k`.

 **Vowel letters**  in English are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

 

 **Example 1:** 

```
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

```

 **Example 2:** 

```
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

```

 **Example 3:** 

```
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of lowercase English letters.
- 1 <= k <= s.length

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 82.35%)  
**Memory:** 45.8 MB (beats 98.07%)  
**Submitted:** 2026-10-23T07:45:57.109Z  

```java
// TC = O(n)
// SC = O(1)

class Solution {
    public boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

    public int maxVowels(String s, int k) {
        int n = s.length();

        int maxCount = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int count = 0;

        while(j < n) {

            char ch = s.charAt(j);
            if(isVowel(ch)) {
                count++;
            }

            if(j - i + 1 == k) {
                
                maxCount = Math.max(maxCount, count);

                char prevCh = s.charAt(i);
                if(isVowel(prevCh)) {
                    count--;
                }

                i++;
            }

            j++;
        }

        return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)