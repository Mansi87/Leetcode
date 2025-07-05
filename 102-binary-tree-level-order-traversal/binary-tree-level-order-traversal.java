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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root==null)  return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++){
                TreeNode curr = queue.poll();
                subList.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}