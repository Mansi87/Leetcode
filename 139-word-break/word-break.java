class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); 
        Map<Integer, Boolean> memo = new HashMap<>();  
        return canBreak(s, 0, wordSet, memo);
    }

    private boolean canBreak(String s, int start, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (start == s.length()) return true; 

        if (memo.containsKey(start)) return memo.get(start); 

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix) && canBreak(s, end, wordSet, memo)) {
                memo.put(start, true); 
                return true;
            }
        }

        memo.put(start, false); 
        return false;
    }
}
