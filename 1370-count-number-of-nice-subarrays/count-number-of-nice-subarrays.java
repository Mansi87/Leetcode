class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;
        int oddcnt=0;
        int ans=0;
        for(int num: nums){
            oddcnt += num & 1;
            if(oddcnt - k>=0){
                ans += cnt[oddcnt-k];
            }
            cnt[oddcnt]++;
        }
        return ans;
    }
}