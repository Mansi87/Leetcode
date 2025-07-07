/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Tuple{
        int row, val;
        Tuple(int row, int val){
            this.row = row;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Tuple>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for(List<Tuple> list: map.values()){
            Collections.sort(list, (a,b)->a.row == b.row?a.val-b.val:a.row-b.row);
            List<Integer> col = new ArrayList<>();
            for(Tuple t:list) col.add(t.val);
            result.add(col);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col, TreeMap<Integer, List<Tuple>> map){
        if(node==null)  return;
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Tuple(row, node.val));

        dfs(node.left, row+1, col-1, map);
        dfs(node.right, row+1, col+1, map);
    }
    
}