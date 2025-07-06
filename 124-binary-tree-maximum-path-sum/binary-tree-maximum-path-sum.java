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
    public int maxPathSum(TreeNode root) {
        int[] maxVal = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        path(root, maxVal);
        return maxVal[0];
    }

    private int path(TreeNode node, int[] maxVal){
        if(node==null)  return 0;
        int l = Math.max(0, path(node.left, maxVal));
        int r = Math.max(0, path(node.right, maxVal));
        maxVal[0] = Math.max(maxVal[0], l+r+node.val);
        return node.val + Math.max(l,r);
    }
}