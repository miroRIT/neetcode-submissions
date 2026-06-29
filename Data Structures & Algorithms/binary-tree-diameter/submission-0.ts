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
    diameterOfBinaryTree(root: TreeNode | null): number {
        let maxDiameter = 0;

        function getDepth(node: TreeNode | null): number {
            if (node === null) return 0;

            // Recursively find depth of left and right subtrees
            let leftDepth = getDepth(node.left);
            let rightDepth = getDepth(node.right);

            // The diameter at this specific node is the sum of left and right depths
            maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

            // Return height to the parent node
            return Math.max(leftDepth, rightDepth) + 1;
        }

        getDepth(root);
        return maxDiameter;
    }
}
