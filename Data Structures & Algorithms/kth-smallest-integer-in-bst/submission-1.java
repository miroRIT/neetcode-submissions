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
    public int cnt;
    public int res;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        res = root.val;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if (node == null) return;

        dfs(node.left);
        if (cnt == 0) return;
        cnt--;
        if (cnt == 0){
            res = node.val;
            return;
        }
        dfs(node.right);
    }
}
