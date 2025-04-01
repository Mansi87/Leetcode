class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num: nums){
            if(num>high) high = num;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(sumofD(nums, mid) <= threshold){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    public int sumofD(int[]arr, int div){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += Math.ceil((double)(arr[i])/(double)(div));
        }
        return sum;
    }
}