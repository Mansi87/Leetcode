class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;

        int count = 1;
        int prev = 0;
        for(int i=1; i<nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if((diff>0 && prev <=0) || (diff<0 && prev>=0)){
                count++;
                prev = diff;
            }
        }
        return count;
    }
}