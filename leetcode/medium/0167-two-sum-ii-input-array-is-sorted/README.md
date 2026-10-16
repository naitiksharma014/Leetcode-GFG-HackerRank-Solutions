# Two Sum II - Input Array Is Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a  **1-indexed**  array of integers `numbers` that is already  **sorted in non-decreasing order**.

Find  **two**  numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers `index1` and `index2` as an integer array `[index1, index2]` of length 2.

The tests are generated such that there is  **exactly one solution**. You  **may not**  use the same element twice.

Your solution must use only constant extra space.

 

 **Example 1:** 

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

```

 **Example 2:** 

```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

```

 **Example 3:** 

```
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

```

 

 **Constraints:** 

- 2 <= numbers.length <= 3 * 104
- -1000 <= numbers[i] <= 1000
- numbers is sorted in non-decreasing order.
- -1000 <= target <= 1000
- The tests are generated such that there is exactly one solution.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 17.01%)  
**Memory:** 48.3 MB (beats 79.53%)  
**Submitted:** 2026-10-16T15:53:04.444Z  

```java
// 2 Pointer Approach
// TC: O(n)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int[] ans = new int[2];
        int i = 0, j = n - 1;

        while(i < n && j >= 0) {

            if(numbers[i] + numbers[j] == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;

                return ans;
            }
            else if(numbers[i] + numbers[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)