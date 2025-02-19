class Solution {
    public void sortColors(int[] nums) {
        int l=0, m=0, h=nums.length-1;
        while(m <= h){
            if(nums[m] == 0){
                swap(nums, l, m);
                l++;
                m++;
            }
            else if(nums[m] == 1){
                m++;
            }
            else{
                swap(nums, m, h);
                h--;
            }
        }
    }

    private void swap(int[]nums, int right, int left){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
    }        
}