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
    public int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        getDepth(root);
        return maxDia;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        maxDia = Math.max(maxDia, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
