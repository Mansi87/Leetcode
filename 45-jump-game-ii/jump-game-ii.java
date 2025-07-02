class Solution {
    public int jump(int[] nums) {
        int jump=0, l=0, r=0;
        
        while(r<nums.length-1){
            int far=0;
            for(int ind=l; ind<=r; ind++){
                far = Math.max(far, ind+nums[ind]);
            }
            l=r+1;
            r=far;
            jump++;
        }
        return jump;
    }
}