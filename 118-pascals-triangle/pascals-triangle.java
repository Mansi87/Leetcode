class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ans.add(genRow(i));
        }
        return ans;
    }
    private List<Integer> genRow(int row){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col=1; col<row; col++){
            ans = ans*(row-col);
            ans = ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}