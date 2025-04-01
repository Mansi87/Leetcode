class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k)  return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        while(low<=high){
            int mid = (low+high)/2;
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
            }
            else{
                nofb += (cnt/k);
                cnt = 0;
            }
        }
        nofb += (cnt/k);
        return nofb >= m;
    }
}