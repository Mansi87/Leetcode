class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean vis[] = new boolean[v];
        int cnt = 0;
        for(int i=0; i<v; i++){
            if(!vis[i]){
                cnt++;
                dfs(isConnected, vis, i);
            }
        }
        return cnt;
    }

    private static void dfs(int[][]isConnected, boolean[]vis, int node){
        vis[node] = true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[node][i]==1 && !vis[i]){
                dfs(isConnected, vis, i);
            }
        }
    }
}