# Minimum Absolute Difference in BST

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `root` of a Binary Search Tree (BST), return  *the minimum absolute difference between the values of any two different nodes in the tree*.

 

 **Example 1:** 

```
Input: root = [4,2,6,1,3]
Output: 1

```

 **Example 2:** 

```
Input: root = [1,0,48,null,null,12,49]
Output: 1

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [2, 104].
- 0 <= Node.val <= 105

 

 **Note:**  This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 45.86%)  
**Memory:** 46.2 MB (beats 95.30%)  
**Submitted:** 2026-11-01T15:46:06.362Z  

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   TreeNode prev = null;
   int minDiff = Integer.MAX_VALUE;

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        solve(root.left);

        if(prev != null) {
            int diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(minDiff, diff);
        }
        prev = root;


        solve(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        solve(root);
        return minDiff;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)