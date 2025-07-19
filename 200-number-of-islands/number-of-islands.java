class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {

    private void bfs(int row, int col, int[][]vis, char[][]grid){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int m = grid.length;
        int n = grid[0].length;

        int[] dRow = {-1, 0, 1, 0}; 
        int[] dCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int currRow = q.peek().first;
            int currCol = q.peek().second;
            q.remove();

           for (int i = 0; i < 4; i++) {
                int nrow = currRow + dRow[i];
                int ncol = currCol + dCol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cnt = 0;
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
}
