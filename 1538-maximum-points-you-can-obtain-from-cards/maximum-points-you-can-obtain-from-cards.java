class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=0, r=0, maxSum=0;
        for(int i=0; i<k; i++){
            l += cardPoints[i];
            maxSum = l;
        }
        int rind = cardPoints.length-1;
        for(int i=k-1; i>=0; i--){
            l = l - cardPoints[i];
            r += cardPoints[rind];
            rind--;
            maxSum = Math.max(maxSum, l+r);
        }
        return maxSum;
    }
}