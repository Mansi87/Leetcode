class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;
        if(n==1) return;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
                reverse(nums, 0, n-1);
                return;
        }
        for(int i=n-1; i>ind; i--){
            if(nums[i] > nums[ind]){
                swap(nums, i, ind);
                break;
            }
        }
        reverse(nums, ind+1, n-1);

    }
    private void swap(int[]nums, int r, int l){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
    }

    private void reverse(int[]nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
}