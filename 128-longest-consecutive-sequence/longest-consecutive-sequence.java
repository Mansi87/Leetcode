class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 0;
        if(n==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        for(int num: set){
            if(set.contains(num-1) == false){
                int current = num;
                int cnt=1;
            
            while(set.contains(current+1)){
                current++;
                cnt++;
            }
            longest = Math.max(longest,cnt);
            }    
        }
        return longest;
    }
}