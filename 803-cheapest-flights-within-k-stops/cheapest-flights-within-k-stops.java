class Pair{
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class tuple{
    int first, second, third;
    tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, src, 0));
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        while(!q.isEmpty()){
            tuple it = q.peek();
            q.remove();
            int stop = it.first;
            int node = it.second;
            int cost = it.third;
            if(stop>k)  continue;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int edwt = iter.second;
                if(cost+edwt < dist[adjNode] && stop<=k){
                    dist[adjNode] = cost + edwt;
                    q.add(new tuple(stop+1, adjNode, cost+edwt));
                }
            }
        }
        if(dist[dst] == (int)(1e9))  return -1;
        return dist[dst];
    }
}