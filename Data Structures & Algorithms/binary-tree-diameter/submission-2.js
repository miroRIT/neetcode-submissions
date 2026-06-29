/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {number}
     */
    diameterOfBinaryTree(root) {
        let maxDia = 0;

        function getDepth(root){
            if (root === null) return 0

            let leftDepth = getDepth(root.left)
            let rightDepth = getDepth(root.right)

            maxDia = Math.max(maxDia, leftDepth + rightDepth)

            return Math.max(leftDepth, rightDepth) + 1
        }
        getDepth(root)
        return maxDia
    }
}
