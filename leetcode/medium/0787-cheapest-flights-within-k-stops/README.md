# Cheapest Flights Within K Stops

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` cities connected by some number of flights. You are given an array `flights` where `flights[i] = [fromi, toi, pricei]` indicates that there is a flight from city `fromi` to city `toi` with cost `pricei`.

You are also given three integers `src`, `dst`, and `k`, return  ***the cheapest price**  from  *`src`*  to  *`dst`*  with at most  *`k`*  stops. *If there is no such route, return `-1`.

 

 **Example 1:** 

```
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

```

 **Example 2:** 

```
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

```

 **Example 3:** 

```
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

```

 

 **Constraints:** 

- 2 <= n <= 100
- 0 <= flights.length <= (n * (n - 1) / 2)
- flights[i].length == 3
- 0 <= fromi, toi < n
- fromi != toi
- 1 <= pricei <= 104
- There will not be any multiple flights between two cities.
- 0 <= src, dst, k < n
- src != dst

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 83.85%)  
**Memory:** 46.6 MB (beats 42.78%)  
**Submitted:** 2026-10-11T14:49:06.735Z  

```java
// K = Maximum number of stops allowed
// TC: O(K * N²)
// SC: O(N²)

class Solution {
    class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {

            graph[i] = new ArrayList<>();
        }

        for(int[] flight: flights) {

            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            graph[u].add(new Edge(u, v, cost));
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        q.add(new int[]{src, 0, -1});     // src, cost, stop

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int u = curr[0];
            int cost = curr[1];
            int stop = curr[2];

            for(Edge e: graph[u]) {

                int v = e.destination;
                int wt = e.weight;

                if(dist[v] > cost + wt && stop + 1 <= k) {

                    dist[v] = cost + wt;
                    q.add(new int[]{v, dist[v], stop + 1});
                }
            } 
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/cheapest-flights-within-k-stops/)