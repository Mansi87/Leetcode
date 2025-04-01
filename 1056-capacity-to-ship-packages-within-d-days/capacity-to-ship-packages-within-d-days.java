class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int heavy = 0;
        int sum = 0;
        for(int weight: weights){
            sum += weight;
            heavy = Math.max(heavy, weight);
        }

        int low = Math.max(heavy, sum/days);
        int high = heavy * (int) Math.ceil((double)weights.length/days);

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