class tuple{
    int first, second, third;
    tuple(int _first, int _second, int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] src = {0, 0};
        int[] dest = {n-1, m-1};

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;
        if(src[0]==dest[0] && src[1]==dest[1])  return 1;
        Queue<tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[src[0]][src[1]] = 1;
        q.add(new tuple(1, src[0], src[1]));
        int dr[] = {-1, 0, 1, 0, -1, -1, 1, 1};
        int dc[] = {0, -1, 0, 1, 1, -1, -1, 1};
        while(!q.isEmpty()){
            tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int r = it.second;
            int c = it.third;
            for(int i=0; i<8; i++){
                int newr = r+dr[i];
                int newc = c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==0 && dis+1<dist[newr][newc]){
                    dist[newr][newc] = 1+dis;
                    if(newr == dest[0] && newc == dest[1]){
                        return dis+1;
                    }
                    q.add(new tuple(dis+1, newr, newc));
                }
            }
        }
        return -1;
    }
}