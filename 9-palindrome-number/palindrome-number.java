class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))  return false;
        int rev = 0;
        int original = x;
        while(x>0){
            int ld = x%10;
            x = x/10;
            rev = rev*10+ld;
        }
        if(rev==original) return true;
        else return false;
    }
}