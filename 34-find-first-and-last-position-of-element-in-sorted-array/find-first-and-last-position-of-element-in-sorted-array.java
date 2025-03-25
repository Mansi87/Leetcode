class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstoccur(nums, target);
        if(first==-1) return new int[]{-1,-1};
        int last = lastoccur(nums, target);
        return new int[]{first,last};
    }
    private int firstoccur(int[]nums, int target){
        int low = 0;
        int high = nums.length-1;
        int first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }            
        }
        return first;
    }

    private int lastoccur(int[]nums, int target){
        int low = 0;
        int high = nums.length-1;
        int last= -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                last = mid;
                low = mid+1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }            
        }
        return last;
    }
}