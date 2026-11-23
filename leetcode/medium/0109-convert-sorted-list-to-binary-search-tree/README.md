# Convert Sorted List to Binary Search Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `head` of a singly linked list where elements are sorted in  **ascending order**, convert  *it to a   height-balanced binary search tree*.

 

 **Example 1:** 

```
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

```

 **Example 2:** 

```
Input: head = []
Output: []

```

 

 **Constraints:** 

- The number of nodes in head is in the range [0, 2 * 104].
- -105 <= Node.val <= 105

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 30.92%)  
**Memory:** 46.2 MB (beats 92.00%)  
**Submitted:** 2026-11-23T15:50:19.395Z  

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

// TC: O(n * logn)
// SC: O(logn)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;

        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half
        if (slowPrev != null) {
            slowPrev.next = null;
        }


        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)