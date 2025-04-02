class Solution {
    public int splitArray(int[] nums, int k) {
        return SplitSum(nums, k);
    }
    public static int SplitSum(int[]nums, int k) {
    
        int low = 0;
        int high = 0;
        for(int num:nums){
            low = Math.max(num,low);
            high += num;
        }

        while(low<=high){
            int mid = low+(high-low)/2;
            int subArr = cntsub(nums, mid);
            if(subArr>k)  low = mid+1;
            else  high = mid-1;
        }
        return low;
    }

    private static int cntsub(int[]nums, int maxsum){
        int subArr = 1;
        int current = 0;
        for(int num:nums){
            if(current + num <= maxsum){
                current += num;
            }
            else{
                subArr++;
                current = num;
            }
        }
        return subArr;
    }
}