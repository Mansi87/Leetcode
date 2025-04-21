class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int ind, int[] candidates, int target, List<Integer> curr, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target<0)   return;

        for(int i = ind; i<candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(i, candidates, target-candidates[i], curr, result);
            curr.remove(curr.size()-1);
        }
    }
}