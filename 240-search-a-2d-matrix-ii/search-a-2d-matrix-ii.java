class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        int row = 0, col = n-1;
        while(row<m && col>=0){
            int val = matrix[row][col];
            if(val == target)  return true;
            else if(val < target)  row++;
            else  col--;
        }
        return false;
    }
}