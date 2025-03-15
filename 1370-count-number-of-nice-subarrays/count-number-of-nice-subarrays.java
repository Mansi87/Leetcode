class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt = 0; 
        int oddcnt = 0;
        for(int num: nums){
            if(num%2 != 0) oddcnt++;
            cnt += map.getOrDefault(oddcnt-k, 0);
            map.put(oddcnt, map.getOrDefault(oddcnt,0)+1);
        }
        return cnt;
    }
}