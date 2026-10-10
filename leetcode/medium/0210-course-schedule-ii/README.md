# Course Schedule II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you  **must**  take course `bi` first if you want to take course `ai`.

- For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return  *the ordering of courses you should take to finish all courses*. If there are many valid answers, return  **any**  of them. If it is impossible to finish all courses, return  **an empty array**.

 

 **Example 1:** 

```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

```

 **Example 2:** 

```
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

```

 **Example 3:** 

```
Input: numCourses = 1, prerequisites = []
Output: [0]

```

 

 **Constraints:** 

- 1 <= numCourses <= 2000
- 0 <= prerequisites.length <= numCourses * (numCourses - 1)
- prerequisites[i].length == 2
- 0 <= ai, bi < numCourses
- ai != bi
- All the pairs [ai, bi] are distinct.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 81.56%)  
**Memory:** 47.1 MB (beats 30.76%)  
**Submitted:** 2026-10-10T10:00:45.318Z  

```java
// Topological Sort-> Kahn's Algorithm

// Time Complexity: O(V + E)
// Space Complexity: O(V + E)

// where V = number of courses and
// E = number of prerequisite relations.

class Solution {
    int v;

    class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source =  source; 
            this.destination = destination;
        }
    }

    public int[] topologicalSort(ArrayList<Edge>[] graph, int[] indegree) {
        int[] res = new int[v];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++) {

            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;
        while(!q.isEmpty()) {

            int curr = q.poll();
            res[idx++] = curr;

            for(Edge e: graph[curr]) {

                int src = e.source;
                int dest = e.destination;

                indegree[dest]--;

                if(indegree[dest] == 0) {
                    q.add(dest);
                }
            }
        }

        return idx == v ? res : new int[]{}; 
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        v = numCourses;

        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[v];

        for(int[] prerequisite: prerequisites) {

            int a = prerequisite[0];
            int b = prerequisite[1];

            graph[b].add(new Edge(b, a));
            indegree[a]++;
        }

        return topologicalSort(graph, indegree);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/course-schedule-ii/)