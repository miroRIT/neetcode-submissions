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
    public boolean validate(TreeNode node, double left, double right) {
        if (node == null)
            return true;

        if (!(left < node.val && node.val < right))
            return false;

        return validate(node.left, left, node.val) && validate(node.right, node.val, right);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}
