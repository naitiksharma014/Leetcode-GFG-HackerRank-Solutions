# Binary Tree Right Side View

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree, imagine yourself standing on the  **right side**  of it, return  *the values of the nodes you can see ordered from top to bottom*.

 

 **Example 1:** 

 **Input:**  root = [1,2,3,null,5,null,4]

 **Output:**  [1,3,4]

 **Explanation:** 

 **Example 2:** 

 **Input:**  root = [1,2,3,4,null,null,null,5]

 **Output:**  [1,3,4,5]

 **Explanation:** 

 **Example 3:** 

 **Input:**  root = [1,null,3]

 **Output:**  [1,3]

 **Example 4:** 

 **Input:**  root = []

 **Output:**  []

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 78.88%)  
**Memory:** 43 MB (beats 94.47%)  
**Submitted:** 2026-11-05T12:33:23.866Z  

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
    public List<Integer> preOrder(TreeNode root, int level, List<Integer> res){
        if(root == null) return res;

        if(res.size() < level){
            res.add(root.val);
        }

        preOrder(root.right , level + 1 , res);
        preOrder(root.left , level + 1 , res);

        return res;
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        return preOrder(root , 1 , res);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-right-side-view/)