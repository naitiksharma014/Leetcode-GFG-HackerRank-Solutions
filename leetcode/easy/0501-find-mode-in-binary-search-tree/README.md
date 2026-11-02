# Find Mode in Binary Search Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `root` of a binary search tree (BST) with duplicates, return  *all the mode(s) (i.e., the most frequently occurred element) in it*.

If the tree has more than one mode, return them in  **any order**.

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than or equal to the node's key.
- The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
- Both the left and right subtrees must also be binary search trees.

 

 **Example 1:** 

```
Input: root = [1,null,2,2]
Output: [2]

```

 **Example 2:** 

```
Input: root = [0]
Output: [0]

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 104].
- -105 <= Node.val <= 105

 

 **Follow up:**  Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 46.2 MB (beats 93.60%)  
**Submitted:** 2026-11-02T11:05:19.974Z  

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
    int currNum = 0;
    int currFreq = 0;
    int maxFreq = 0;
    List<Integer> res = new ArrayList<>();

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        solve(root.left);

        if(currNum == root.val) {
            currFreq++;
        }
        else {
            currNum = root.val;
            currFreq = 1;
        }

        if(currFreq > maxFreq) {
            maxFreq = currFreq;
            res = new ArrayList<>();
        }
        if(currFreq == maxFreq) {
            res.add(currNum);
        }

        solve(root.right);
    }

    public int[] findMode(TreeNode root) {
        solve(root);

        int[] ans = new int[res.size()];

        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-mode-in-binary-search-tree/)