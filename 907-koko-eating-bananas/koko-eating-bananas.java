class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while(low <= high){
            int mid = (low+high)/2;
            int totalhr = func(piles, mid);
            if(totalhr <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    public int func(int[]arr, int hr){
        int totalhr = 0;
        for(int i =0; i<arr.length; i++){
            totalhr += Math.ceil((double)arr[i]/hr);
        }
        return totalhr;
    }

    public int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }
}