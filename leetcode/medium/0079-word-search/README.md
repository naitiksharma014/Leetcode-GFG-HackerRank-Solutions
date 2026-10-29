# Word Search

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` grid of characters `board` and a string `word`, return `true`  *if*  `word`  *exists in the grid*.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

 **Example 1:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

```

 **Example 2:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

```

 **Example 3:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

```

 

 **Constraints:** 

- m == board.length
- n = board[i].length
- 1 <= m, n <= 6
- 1 <= word.length <= 15
- board and word consists of only lowercase and uppercase English letters.

 

 **Follow up:**  Could you use search pruning to make your solution faster with a larger `board`?

## Solution

**Language:** Java  
**Runtime:** 134 ms (beats 55.43%)  
**Memory:** 42.2 MB (beats 98.62%)  
**Submitted:** 2026-10-29T06:21:22.385Z  

```java
// Time Complexity: O(m * n * 4^L)
// Auxiliary Space Complexity: O(L) ; L = length of word.

class Solution {
    int m, n;

    public boolean solve(int i, int j, int idx, char[][] board, String word) {
        if(idx == word.length()) {
            return true;
        }

        if(i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp   = board[i][j]; 
        board[i][j] = '$';

        boolean found =
            solve(i + 1, j, idx + 1, board, word) ||
            solve(i - 1, j, idx + 1, board, word) ||
            solve(i, j + 1, idx + 1, board, word) ||
            solve(i, j - 1, idx + 1, board, word);

        board[i][j] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == word.charAt(0)) {
                    if(solve(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/word-search/)