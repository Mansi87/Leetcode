class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k)  return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int day: bloomDay){
            if(day>high) high = day;
            if(day<low) low = day;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean possible(int[]arr, int day, int m, int k){
        int cnt = 0;
        int nofb = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=day){
                cnt++;
                if(cnt == k){
                    nofb++;
                    cnt = 0;
                    if(nofb == m) return true;
                }
            }
            else{
                cnt = 0;
                if(arr.length - i <(m-nofb)*k) return false;
            }
        }
       return false;
    }
}