class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            if(s==null || s.length()==0)  return 0;
            if(map.containsKey(ch) && map.get(ch)>=l){
                l = map.get(ch)+1;
            }
            map.put(ch, r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}