# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return root
        
        cur = root
        prev = None
        while cur and cur.val != key:
            prev = cur
            if key > cur.val:
                cur = cur.right
            else:
                cur = cur.left
        
        if not cur:
            return root

        if not cur.left or not cur.right:
            child = cur.left if cur.left else cur.right
            if not prev:
                return child
            if prev.left == cur:
                prev.left = child
            else:
                prev.right = child
        else:
            par = None
            delNode = cur
            cur = cur.right
            while cur.left:
                par = cur
                cur = cur.left
            
            if par:
                par.left = cur.right
                cur.right = delNode.right
            
            cur.left = delNode.left

            if not prev:
                return cur
            
            if prev.left == delNode:
                prev.left = cur
            else:
                prev.right = cur
        
        return root