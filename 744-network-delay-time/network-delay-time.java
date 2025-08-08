import java.util.*;

class Pair {
    int first;   
    int second;  
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];
            adj.get(u).add(new Pair(w, v)); 
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Pair(0, k - 1));

        while (!pq.isEmpty()) {
            int d = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.second;
                int edwt = it.first;

                if (d + edwt < dist[adjNode]) {
                    dist[adjNode] = d + edwt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        int maxTime = 0;
        for (int time : dist) {
            if (time == Integer.MAX_VALUE) return -1; 
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
