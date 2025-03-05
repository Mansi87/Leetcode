class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                swap(matrix, i,j,j,i);
            }
        }
        for(int i=0; i<n; i++){
            reverse(matrix[i]);
        }
    }
    private void swap(int[][]matrix, int x1, int y1, int x2, int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }    
    private void reverse(int[]row){
        int left=0, right = row.length-1;
        while(left<right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}