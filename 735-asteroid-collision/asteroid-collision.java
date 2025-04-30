class Solution {
    public int[] asteroidCollision(int[] arr) {
      
       int left = 0;
       int right = 1;
       while(right<arr.length){
        int curr = arr[right];
        if(curr<0){
            while(left>=0 && arr[left]>=0 && -curr>arr[left]){
                left--;
            }
            if(left==-1 || arr[left]<0){
             arr[++left] = curr;
            } 
            else if(arr[left]== -curr){
             left--;
            }
        }
        else{
            arr[++left] = curr;
        }
        right++;
       }
       return Arrays.copyOfRange(arr,0,left+1);
    }
}