# Letter Combinations of a Phone Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in  **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Original
Java
 **Example 1:** 

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

```

 **Example 2:** 

```
Input: digits = "2"
Output: ["a","b","c"]

```

 

 **Constraints:** 

- 1 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.7 MB (beats 97.32%)  
**Submitted:** 2026-11-14T09:01:32.905Z  

```java
// Time Complexity: O(n * 4ⁿ)
// Space Complexity: O(n * 4ⁿ) - including output
// Auxiliary Space: O(n)

class Solution {
    int n;
    ArrayList<String> result = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();

    public void solve(int idx, String digits, StringBuilder str) {
        if(idx >= n) {
            result.add(str.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String temp = map.get(digit);

        for(int i = 0; i < temp.length(); i++) {

            str.append(temp.charAt(i));

            solve(idx + 1, digits, str);

            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;

        n = digits.length();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder str = new StringBuilder();

        solve(0, digits, str);

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)