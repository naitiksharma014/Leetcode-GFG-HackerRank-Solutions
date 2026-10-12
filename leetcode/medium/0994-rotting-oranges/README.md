# Rotting Oranges

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` `grid` where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.

Every minute, any fresh orange that is  **4-directionally adjacent**  to a rotten orange becomes rotten.

Return  *the minimum number of minutes that must elapse until no cell has a fresh orange*. If  *this is impossible, return*  `-1`.

 

 **Example 1:** 

```
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

```

 **Example 2:** 

```
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

```

 **Example 3:** 

```
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 10
- grid[i][j] is 0, 1, or 2.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 86.54%)  
**Memory:** 44.4 MB (beats 23.87%)  
**Submitted:** 2026-10-12T14:57:57.637Z  

```java
// Multi-Source BFS
// ⏱️ TC: O(m × n) + O(4 × m × n) ≈ O(m × n)
// 📦 SC: Queue → O(m × n)

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {            // Rotten Orange
                    q.add(new int[]{i, j});     // All Possible Sources
                }
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {

           int N = q.size();

            while(N--> 0) {

                int[] curr = q.remove();

                int i = curr[0];
                int j = curr[1];

                for(int[] direction: directions) {

                    int new_i = i + direction[0];
                    int new_j = j + direction[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {

                        grid[new_i][new_j] = 2;
                        freshOranges--;

                        q.add(new int[]{new_i, new_j});
                    }
                }
            }

            minutes++;
        }

        return freshOranges == 0 ? minutes - 1 : -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotting-oranges/)