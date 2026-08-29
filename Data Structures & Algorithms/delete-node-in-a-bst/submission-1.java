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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        TreeNode cur = root, prev = null;

        while (cur != null && cur.val != key) {
            prev = cur;
            if (key > cur.val)
                cur = cur.right;
            else
                cur = cur.left;
        }

        if (cur == null)
            return root;

        if (cur.left == null || cur.right == null) {
            TreeNode child = (cur.left != null) ? cur.left : cur.right;
            if (prev == null)
                return child;

            if (prev.left == cur)
                prev.left = child;
            else
                prev.right = child;
        } else {
            TreeNode par = null, delNode = cur;
            cur = cur.right;

            while (cur.left != null) {
                par = cur;
                cur = cur.left;
            }

            if (par != null) {
                par.left = cur.right;
                cur.right = delNode.right;
            }

            cur.left = delNode.left;

            if (prev == null)
                return cur;

            if (prev.left == delNode)
                prev.left = cur;
            else
                prev.right = cur;
        }

        return root;
    }
}