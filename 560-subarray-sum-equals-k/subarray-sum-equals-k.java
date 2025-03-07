class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sub = new HashMap<>();
        sub.put(0, 1);
        int presum = 0, cnt = 0;
        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            int remove = presum-k;
            cnt += sub.getOrDefault(remove,0);
            sub.put(presum, sub.getOrDefault(presum,0)+1);
        }
        return cnt;
    }
}