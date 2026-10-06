# Reorder Routes to Make All Paths Lead to the City Zero

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` cities numbered from `0` to `n - 1` and `n - 1` roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by `connections` where `connections[i] = [ai, bi]` represents a road from city `ai` to city `bi`.

This year, there will be a big event in the capital (city `0`), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city `0`. Return the  **minimum**  number of edges changed.

It's  **guaranteed**  that each city can reach city `0` after reorder.

 

 **Example 1:** 

```
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

```

 **Example 2:** 

```
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

```

 **Example 3:** 

```
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

```

 

 **Constraints:** 

- 2 <= n <= 5 * 104
- connections.length == n - 1
- connections[i].length == 2
- 0 <= ai, bi <= n - 1
- ai != bi

## Solution

**Language:** Java  
**Runtime:** 29 ms (beats 95.23%)  
**Memory:** 116.9 MB (beats 37.15%)  
**Submitted:** 2026-10-06T15:40:39.793Z  

```java
// ⏱️ TC: O(V + E)
// 💾 SC: O(V + E)

class Solution {
    
    static class Edge {
        int src, dest;
        int cost; 
        
        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    int count = 0;

    public void DFS(int curr, ArrayList<Edge> graph[], boolean[] visited){
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            int nei = e.dest;
            int cost = e.cost;

            if(!visited[nei]) {
                
                if(cost == 1) {
                    count++;
                }
                DFS(nei, graph, visited);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] connection: connections) {

            int u = connection[0];
            int v = connection[1];

            // REAL: u -> v (1)
            // FAKE: v -> u (0)

            // original edge → needs reversal
            graph[u].add(new Edge(u, v, 1));

            // reverse edge → already correct
            graph[v].add(new Edge(v, u, 0));
        }

        boolean[] visited = new boolean[n];
        DFS(0, graph, visited);
        
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)