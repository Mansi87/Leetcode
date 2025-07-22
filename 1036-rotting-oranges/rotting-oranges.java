class Pair{
    int row;
    int col;
    int t;
    Pair(int _row, int _col, int _t){
        this.row = _row;
        this.col = _col;
        this.t = _t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int t=0;
        int dRow[] = {-1, 0, +1, 0};
        int dCol[] = {0, 1, 0, -1};
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int tm = q.peek().t;
            t = Math.max(t, tm);
            q.remove();
            for(int i=0; i<4; i++){
                int nrow = r+dRow[i];
                int ncol = c+dCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh)  return -1;
        return t; 
    }
}