class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        if(n==1)  return nums[0];
        for(int i=0; i<n; i++){
            if(i != 0)  temp1.add(nums[i]);
            if(i != n-1)  temp2.add(nums[i]);  
        }
        return Math.max(simprob(temp1), simprob(temp2));
    }

    public int simprob(List<Integer> nums){
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int pick = nums.get(i);
            if(i>1) pick += prev2;
            int nonpick = 0+prev;
            int curr = Math.max(pick, nonpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}