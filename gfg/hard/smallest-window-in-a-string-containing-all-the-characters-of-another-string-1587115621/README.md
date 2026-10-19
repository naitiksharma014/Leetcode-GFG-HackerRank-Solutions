# Smallest Window with All

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two strings  **s**  and  **p**, find the smallest substring in s consisting of all the characters (including duplicates) of the string p.

- Return empty string in case no such substring is present. 
- If there are multiple such substring of the same length found, return the one with the least starting index.

 **Examples:** 

```
Input: s = "timetopractice", p = "toc"
Output: "toprac"
Explanation: "toprac" is the smallest substring in which "toc" can be found.

```

```
Input: s = "zoomlazapzo", p = "oza"
Output: "apzo"
Explanation: "apzo" is the smallest substring in which "oza" can be found.

```

```
Input: s = "zoom", p = "zooe"
Output: ""
Explanation: No substring is present containing all characters of p.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T13:32:15.697Z  

```java
class Solution {
    public static String minWindow(String s, String t) {
        // code here
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

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1)