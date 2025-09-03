

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int take = n / 2;                 // must pick exactly n/2 elements
        long total = 0L;
        for (int x : nums) total += x;

        int leftSize = n / 2;
        int rightSize = n - leftSize;

        // lists: leftSums[count] = all sums achievable in left half by picking 'count' elements
        List<Long>[] leftSums = new ArrayList[leftSize + 1];
        for (int i = 0; i <= leftSize; i++) leftSums[i] = new ArrayList<>();

        List<Long>[] rightSums = new ArrayList[rightSize + 1];
        for (int i = 0; i <= rightSize; i++) rightSums[i] = new ArrayList<>();

        // generate sums
        gen(nums, 0, leftSize, 0, 0L, leftSums);
        gen(nums, leftSize, n, 0, 0L, rightSums);

        // sort right-side lists for binary search
        for (int i = 0; i <= rightSize; i++) Collections.sort(rightSums[i]);

        long best = Long.MAX_VALUE;
        double halfTotal = total / 2.0;

        // for each possible count taken from left half
        for (int cnt = 0; cnt <= leftSize; cnt++) {
            int need = take - cnt;               // how many must come from right half
            if (need < 0 || need > rightSize) continue;
            List<Long> rightList = rightSums[need];

            for (long ls : leftSums[cnt]) {
                double want = halfTotal - ls;   // we want (ls + rs) close to total/2
                int idx = lowerBound(rightList, want);

                if (idx < rightList.size()) {
                    long selected = ls + rightList.get(idx);
                    long diff = Math.abs(total - 2L * selected);
                    if (diff < best) best = diff;
                }
                if (idx - 1 >= 0) {
                    long selected = ls + rightList.get(idx - 1);
                    long diff = Math.abs(total - 2L * selected);
                    if (diff < best) best = diff;
                }
            }
        }

        return (int) best;
    }

    // generate subset sums for nums[l..r-1], grouped by count of picked elements
    private void gen(int[] nums, int l, int r, int cnt, long cur, List<Long>[] out) {
        if (l == r) {
            out[cnt].add(cur);
            return;
        }
        // not take current
        gen(nums, l + 1, r, cnt, cur, out);
        // take current
        gen(nums, l + 1, r, cnt + 1, cur + nums[l], out);
    }

    // lower bound: first index i with a.get(i) >= key
    private int lowerBound(List<Long> a, double key) {
        int lo = 0, hi = a.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a.get(mid) < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
