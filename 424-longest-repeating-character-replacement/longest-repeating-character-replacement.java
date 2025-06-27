class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0, maxlen=0, maxf=0;
        int[] hash = new int[26];
        while(r<s.length()){
            char c = s.charAt(r);
            hash[c - 'A']++;
    
            maxf = Math.max(maxf, hash[c-'A']);
            if((r-l+1)-maxf > k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            else{
                maxlen = Math.max(maxlen, r-l+1);
            } 
           r++;
        }
        return maxlen;
    }
}