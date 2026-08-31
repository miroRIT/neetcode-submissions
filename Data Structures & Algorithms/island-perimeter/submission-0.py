class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        p = 0
        m, n = len(grid), len(grid[0])

        for r in range(m):
            for c in range(n):
                if grid[r][c] == 1:
                    p += 4
                    if r and grid[r - 1][c]:
                        p -= 2
                    if c and grid[r][c - 1]:
                        p -= 2
        
        return p