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
     * @return {boolean}
     */
    isBalanced(root: TreeNode | null): boolean {
        const getDepth = (root) => {
            if (root === null) return 0;
            let left = getDepth(root.left);
            if (left == -1) return -1;
            let right = getDepth(root.right);
            if (right == -1) return -1;

            if (Math.abs(right - left) > 1) return -1;

            return Math.max(right, left) + 1;
        };
        return getDepth(root) != -1;
    }
}
