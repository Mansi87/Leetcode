class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it: connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, adj, tin, low, bridge);
            }
        }
        return bridge;
    }

    private int timer = 1;
    private void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int tin[], int low[], List<List<Integer>> bridge){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for(Integer it: adj.get(node)){
            if(it==parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, adj, tin, low, bridge);
                low[node] = Math.min(low[node], low[it]);
                if(low[it]> tin[node]){
                    bridge.add(Arrays.asList(node,it));
                }
            }
            else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}