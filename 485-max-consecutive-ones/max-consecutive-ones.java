class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0,maxi=0;
        for(int num: nums){
            if(num == 1){
                count++;
                maxi = (maxi<count)?count:maxi;
            }
            else{
                count=0;
            }
        }
        return maxi;
    }
}