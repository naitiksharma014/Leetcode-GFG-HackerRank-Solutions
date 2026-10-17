# Count Occurences of Anagrams

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a word  **pat**  and a text  **txt**. Return the count of the occurrences of anagrams of the word in the text.

 **Example 1:** 

```
Input: txt = "forxxorfxdofr", pat = "for"
Output: 3
Explanation: for, orf and ofr appears in the txt, hence answer is 3.

```

 **Example 2:** 

```
Input: txt = "aabaabaa", pat = "aaba"
Output: 4
Explanation: aaba is present 4 times in txt.

```

 **Constraints:** 
1 <= |pat| <= |txt| <= 105
Both strings contain lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T16:36:51.228Z  

```java
class Solution {
    
    boolean allZero(int[] freq) {
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    int search(String pat, String txt) {
        // code here
        int m = pat.length();
        int n = txt.length();
        
        int[] freq = new int[26];
        for(char ch: pat.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        int i = 0, j = 0;
        int count = 0;
        
        while(j < n) {
            
            char ch = txt.charAt(j);
            
            freq[ch - 'a']--;
            
            if(j - i + 1 == m) {
                
                if(allZero(freq)) {
                    count++;
                }
                
                char prevCh = txt.charAt(i);
                freq[prevCh - 'a']++;
                i++;
            }
            
            j++;
        }
        
        return count;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)