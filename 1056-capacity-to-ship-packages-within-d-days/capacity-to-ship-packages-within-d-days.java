class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int sum = 0;
        for(int weight: weights){
            if(weight>low)  low = weight;
            sum += weight;
        }
        int high = sum;

        while(low<high){
            int mid = low+(high-low)/2;
            int nofday = func(weights, mid);
            if(nofday <= days){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    private int func(int[]weights, int capacity){
        int day = 1;
        int load = 0;
        for(int weight:weights){
            if(load + weight > capacity){
                day++ ;
                load = weight;
            }
            else{
                load += weight;
            }
        }
        return day;
    }
}