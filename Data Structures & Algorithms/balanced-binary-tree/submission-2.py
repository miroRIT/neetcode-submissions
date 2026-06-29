# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.getDepth(root) != -1
    
    def getDepth(self, root: Optional[TreeNode]) -> int:
        if not root: 
            return 0

        leftDepth = self.getDepth(root.left)
        if leftDepth == -1: return -1
        rightDepth = self.getDepth(root.right)
        if rightDepth == -1: return -1

        # Update the instance variable
        if abs(rightDepth - leftDepth) > 1:
            return -1
        return max(leftDepth, rightDepth) + 1