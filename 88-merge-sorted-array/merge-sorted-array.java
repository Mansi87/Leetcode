class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int l=0, r=0, ind=0;
        while(l<m && r<n){
            if(nums1[l] <= nums2[r]){
                arr[ind] = nums1[l];
                l++;
                ind++;
            }
            else{
                arr[ind] = nums2[r];
                r++;
                ind++;
            }
        }
        while(l<m){
            arr[ind++] = nums1[l++];
        }
        while(r<n){
            arr[ind++] = nums2[r++];
        }
        for(int i=0; i<n+m; i++){
           nums1[i] = arr[i];
        }
    }
}