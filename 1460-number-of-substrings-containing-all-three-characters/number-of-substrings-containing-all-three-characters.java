class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastseen = new int[3];
        Arrays.fill(lastseen, -1);
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            lastseen[ch-'a'] = i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                int minIndex = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
                cnt += (1+ minIndex);
            }
        }
        return cnt;
    }
}