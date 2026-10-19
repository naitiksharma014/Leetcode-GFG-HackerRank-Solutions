# First Negative in Windows of Size K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  and a positive integer  **k**, find the first negative integer for each and every window(contiguous subarray) of size  **k.** 

 **Note:**  If a window does not contain a negative integer, then return 0 for that window.

 **Examples:** 

```
Input: arr[] = [-8, 2, 3, -6, 10], k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.

```

```
Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
Output: [-1, -1, -7, -15, -15, 0] 
Explanation:
Window [12, -1, -7] First negative integer is -1.
Window [-1, -7, 8] First negative integer is -1.
Window [-7, 8, -15] First negative integer is -7.
Window [8, -15, 30] First negative integer is -15.
Window [-15, 30, 16] First negative integer is -15.
Window [30, 16, 28] No negative integers, output is 0.

```

```
Input: arr[] = [12, 1, 3, 5], k = 3
Output: [0, 0] 
Explanation:
Window [12, 1, 3] No negative integers, output is 0.
Window [1, 3, 5] No negative integers, output is 0.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T12:28:39.426Z  

```java
class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // code here
        int n = arr.length;
        
        int i = 0, j = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        while(j < n) {
            
            if(arr[j] < 0) {
                q.add(arr[j]);
            }
            
            if(j - i + 1 == k) {
                
                if(!q.isEmpty()) {
                    list.add(q.peek());
                }
                else {
                    list.add(0);
                }
                
                if(!q.isEmpty() && arr[i] < 0) {
                    q.poll();
                }
                
                i++;
            }
            
            
            j++;
        }
        
        return list;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1)