class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length > threshold) return -1;
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

    public int sumofD(int[]nums, int mid){
        double sum = 0;
        for(int i: nums){
            sum += Math.ceilDiv(i, mid);
        }
        return (int)sum;
    }
}