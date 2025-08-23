import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // edge case
        
        // Case 1: rob from 0 to n-2
        int case1 = robLinear(Arrays.copyOfRange(nums, 0, n - 1));
        
        // Case 2: rob from 1 to n-1
        int case2 = robLinear(Arrays.copyOfRange(nums, 1, n));
        
        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i-2];
            int nonpick = dp[i-1];
            dp[i] = Math.max(pick, nonpick);
        }
        
        return dp[n-1];
    }
}
