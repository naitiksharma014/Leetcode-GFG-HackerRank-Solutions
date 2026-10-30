# Unique Paths III

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an `m x n` integer array `grid` where `grid[i][j]` could be:

- 1 representing the starting square. There is exactly one starting square.
- 2 representing the ending square. There is exactly one ending square.
- 0 representing empty squares we can walk over.
- -1 representing obstacles that we cannot walk over.

Return  *the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once*.

 

 **Example 1:** 

```
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

```

 **Example 2:** 

```
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

```

 **Example 3:** 

```
Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 20
- 1 <= m * n <= 20
- -1 <= grid[i][j] <= 2
- There is exactly one starting cell and one ending cell.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.1 MB (beats 93.14%)  
**Submitted:** 2026-10-30T12:05:39.553Z  

```java
// TC: O(3^K)
// SC: O(K) (recursion stack).

class Solution {
    int m, n;
    int nonObstacle;

    public int solve(int i, int j, int[][] grid, int count) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return count == nonObstacle ? 1 : 0;
        }

        grid[i][j] = -1;

        int left  = solve(i, j - 1, grid, count + 1);
        int right = solve(i, j + 1, grid, count + 1);
        int down  = solve(i + 1, j, grid, count + 1);
        int up    = solve(i - 1, j, grid, count + 1);


        // Backtrack: restore original value
        grid[i][j] = 0;

        return left + right + down + up;
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int start_i = 0, start_j = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                }
                if(grid[i][j] == 0) {
                    nonObstacle++;
                }
            }
        }

        nonObstacle++;
        int count = 0;
        
        return solve(start_i, start_j, grid, count);        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/unique-paths-iii/)