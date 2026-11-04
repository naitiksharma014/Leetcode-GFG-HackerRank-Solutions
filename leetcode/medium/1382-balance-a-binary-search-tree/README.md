# Balance a Binary Search Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary search tree, return  *a  **balanced**  binary search tree with the same node values*. If there is more than one answer, return  **any of them**.

A binary search tree is  **balanced**  if the depth of the two subtrees of every node never differs by more than `1`.

 

 **Example 1:** 

```
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

```

 **Example 2:** 

```
Input: root = [2,1,3]
Output: [2,1,3]

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 104].
- 1 <= Node.val <= 105

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 98.75%)  
**Memory:** 47.4 MB (beats 97.17%)  
**Submitted:** 2026-11-04T12:35:50.442Z  

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
    public void Inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        // Left -> Root -> Right

        Inorder(root.left, list);

        list.add(root.val);

        Inorder(root.right, list);
    } 

    public TreeNode buildBST(int low, int high, List<Integer> list){
        if(low > high){
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(low, mid - 1, list);
        root.right = buildBST(mid + 1, high, list);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // Fill elements in result in sorted form -> Inorder Traversal
        Inorder(root, list);

        return buildBST(0, list.size() - 1, list);
    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/balance-a-binary-search-tree/)