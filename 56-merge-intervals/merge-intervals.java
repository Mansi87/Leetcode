class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        if(intervals.length == 0)  return res.toArray(new int[0][]);
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] curr = intervals[0];
        
        for(int i = 1; i<intervals.length; i++){
            if(curr[1] >= intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            else{
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
}