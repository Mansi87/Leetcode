class Solution {
    public int removeStones(int[][] stones) {
        int maxrow = 0;
        int maxcol = 0;
        for(int i=0; i<stones.length; i++){
            maxrow = Math.max(maxrow, stones[i][0]);
            maxcol = Math.max(maxcol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxrow+ maxcol +1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for(int i=0; i<stones.length; i++){
            int nrow = stones[i][0];
            int ncol = stones[i][1] + maxrow + 1;
            ds.unionBySize(nrow, ncol);
            stoneNodes.put(nrow, 1);
            stoneNodes.put(ncol, 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> it: stoneNodes.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                cnt++;
            }
        }
        return stones.length-cnt;
    }
}

    class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0; i<=n; i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int findUPar(int node){
            if(node == parent.get(node)){
                    return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        public void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v)  return;
            if(size.get(ulp_u)< size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            }
            else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        
        }
    }