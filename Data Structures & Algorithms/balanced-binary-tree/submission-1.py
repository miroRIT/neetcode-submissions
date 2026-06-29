# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.maxDia = True  # Initialize as an instance variable
        self.getDepth(root)
        return self.maxDia
    
    def getDepth(self, root: Optional[TreeNode]) -> int:
        if not root: 
            return 0

        leftDepth = self.getDepth(root.left)
        rightDepth = self.getDepth(root.right)

        # Update the instance variable
        self.maxDia = True if abs(rightDepth - leftDepth) <= 1 and self.maxDia else False

        return max(leftDepth, rightDepth) + 1