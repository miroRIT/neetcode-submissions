"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val=False, isLeaf=False, topLeft=None, topRight=None, bottomLeft=None, bottomRight=None):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""


class Solution:
    def construct(self, grid: List[List[int]]) -> "Node":
        leafNode = {0: Node(False, True), 1: Node(True, True)}

        def dfs(n, r, c):
            if n == 1:
                return leafNode[grid[r][c]]

            n //= 2
            tL = dfs(n, r, c)
            tR = dfs(n, r, c + n)
            bL = dfs(n, r + n, c)
            bR = dfs(n, r + n, c + n)

            if (
                tL.isLeaf
                and tR.isLeaf
                and bL.isLeaf
                and bR.isLeaf
                and tL.val == tR.val == bL.val == bR.val
            ):
                return tL

            return Node(False, False, tL, tR, bL, bR)

        return dfs(len(grid), 0, 0)
