class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int ind, int[] candidates, int target, List<Integer> curr, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = ind; i<candidates.length; i++){
            if(i>ind && candidates[i] == candidates[i-1])   continue;

            if(candidates[i] > target)  return;
            curr.add(candidates[i]);
            backtrack(i+1, candidates, target-candidates[i], curr, result);
            curr.remove(curr.size()-1);
        }
    }
}