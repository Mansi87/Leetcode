class Solution {
    int cnt = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return cnt;
    }
    
    private void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low;      
        int right = mid + 1;   

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    private void countPairs(int[]arr, int low, int mid, int high){
        int right = mid+1;
        for(int i=low; i<=mid; i++){
            while(right<=high && arr[i]> 2L * arr[right]) right++;
            cnt += (right - (mid+1));
        }
    }
    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        countPairs(arr, low, mid ,high);
        merge(arr, low, mid, high);  // merging sorted halves
    }
}