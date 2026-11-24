# Merge k Sorted Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

 *Merge all the linked-lists into one sorted linked-list and return it.* 

 

 **Example 1:** 

```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

```

 **Example 2:** 

```
Input: lists = []
Output: []

```

 **Example 3:** 

```
Input: lists = [[]]
Output: []

```

 

 **Constraints:** 

- k == lists.length
- 0 <= k <= 104
- 0 <= lists[i].length <= 500
- -104 <= lists[i][j] <= 104
- lists[i] is sorted in ascending order.
- The sum of lists[i].length will not exceed 104.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 90.88%)  
**Memory:** 46.8 MB (beats 22.46%)  
**Submitted:** 2026-11-24T15:51:18.932Z  

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

// Time Complexity: O(N * log K)
// Space Complexity: O(N + log K)

// N = Total number of nodes
// K = Number of linked lists

class Solution {
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if(l1.val <= l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);

            return l1;
        }
        else {
            l2.next = mergeTwoSortedLists(l1, l2.next);

            return l2;
        }
    }

    public ListNode partitionAndMerge(int start, int end, ListNode[] lists) {
        if(start == end) {
            return lists[start];
        }

        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        ListNode l1 = partitionAndMerge(start, mid, lists);
        ListNode l2 = partitionAndMerge(mid + 1, end, lists);

        return mergeTwoSortedLists(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if(n == 0) {
            return null;
        }

        return partitionAndMerge(0, n - 1, lists);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/merge-k-sorted-lists/)