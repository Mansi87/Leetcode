class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }

        List<Character>[]buckets = new List[s.length()+1];
        for(char c:freq.keySet()){
            int freqM = freq.get(c);
            if(buckets[freqM] == null){
                buckets[freqM] = new ArrayList<>();
            }
            buckets[freqM].add(c);
        }

        StringBuilder result = new StringBuilder();
        for(int i = buckets.length -1; i>=1; i--){
            if(buckets[i] != null){
                for(char c: buckets[i]){
                    for(int j =0; j<i; j++){
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}