class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int vis[] = new int[graph.length];
        int pathvis[] = new int[graph.length];
        int check[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(vis[i] == 0){
                dfs(i, graph, vis, pathvis, check);
            }
        }
        List<Integer> safe = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(check[i] == 1) safe.add(i);
        }
        return safe;
    }

    private boolean dfs(int node,int[][] graph, int vis[], int pathvis[], int check[]){
        vis[node] = 1;
        pathvis[node] = 1;
        check[node] = 0;
        for(int it: graph[node]){
            if(vis[it] == 0){
                if(dfs(it, graph, vis, pathvis, check) == true){
                    return true;
                }
            }
            else if(pathvis[it] == 1){
                 return true;
            }
        }
        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }
}