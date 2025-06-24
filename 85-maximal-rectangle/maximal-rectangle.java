class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length == 0)  return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] psum = new int[n][m];
        int maxArea = 0;
        for(int j=0; j<m; j++){
            int sum=0;
            for(int i=0; i<n; i++){
                if(matrix[i][j]=='1') sum += 1;
                else  sum = 0;

                psum[i][j] = sum;
            }
        }
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, largestRect(psum[i]));
        }
        return maxArea;
    }

    public int largestRect(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(heights[element]*(nse-pse-1), maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=heights.length;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, (nse-pse-1) * heights[element]);
        }
        return maxArea;
    }
}