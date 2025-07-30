class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); 
        }
        int vis[] = new int[numCourses];
        int pathvis[] = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis, pathvis, order)) return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathvis[], List<Integer> order){
        vis[node] = 1;
        pathvis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfsCheck(it, adj, vis, pathvis, order)){
                    return true;
                }
            }
            if(pathvis[it] == 1){
                return true;
            }
        }
        pathvis[node] = 0;
        order.add(0, node);
        return false;
    }
}