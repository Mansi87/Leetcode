class Solution {
    public int[] asteroidCollision(int[] arr) {
       int[] st = new int[10000];
       st[0] = arr[0];
       int left = 0;
       int right = 1;
       while(right<arr.length){
        int curr = arr[right];
        if(curr<0){
            while(left>=0 && st[left]>=0 && -curr>st[left]){
                left--;
            }
            if(left==-1 || st[left]<0){
             st[++left] = curr;
            } 
            else if(st[left]== -curr){
             left--;
            }
        }
        else{
            st[++left] = curr;
        }
        right++;
       }
       return Arrays.copyOfRange(st,0,left+1);
    }
}