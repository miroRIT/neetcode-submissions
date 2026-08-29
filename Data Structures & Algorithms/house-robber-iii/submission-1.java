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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] {0, 0};

        int[] lp = dfs(root.left);
        int[] rp = dfs(root.right);

        int wr = root.val + lp[1] + rp[1];
        int wor = Math.max(lp[0], lp[1]) + Math.max(rp[0], rp[1]);

        return new int[] {wr, wor};
    }
}