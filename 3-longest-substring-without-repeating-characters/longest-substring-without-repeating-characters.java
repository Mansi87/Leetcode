class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0; 
        int r=0;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if(s==null || s.length()==0)  return 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch)>=l){
                l=map.get(ch)+1;
            }
            map.put(ch, r);
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
    }
}