# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.maxDia = 0
        self.getDepth(root)
        return self.maxDia
    
    def getDepth(self, root: Optional[TreeNode]) -> int:
        if not root: return 0

        leftDepth = self.getDepth(root.left)
        rightDepth = self.getDepth(root.right)

        self.maxDia = max(leftDepth + rightDepth, self.maxDia)

        return max(leftDepth, rightDepth) + 1