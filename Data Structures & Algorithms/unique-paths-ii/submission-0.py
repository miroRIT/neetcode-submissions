class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        if grid[0][0] == 1 or grid[m - 1][n - 1] == 1:
            return 0
        
        grid[m - 1][n - 1] = 1

        for r in range(m - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                if r == m - 1 and c == n - 1:
                    continue
                
                if grid[r][c] == 1:
                    grid[r][c] = 0
                else:
                    d = grid[r + 1][c] if r + 1 < m else 0
                    rt = grid[r][c + 1] if c + 1 < n else 0
                    grid[r][c] = d + rt
        
        return grid[0][0]