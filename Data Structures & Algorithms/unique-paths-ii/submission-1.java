class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return 0;

        grid[m - 1][n - 1] = 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r == m - 1 && c == n - 1)
                    continue;

                if (grid[r][c] == 1)
                    grid[r][c] = 0;
                else {
                    int d = (r + 1 < m) ? grid[r + 1][c] : 0;
                    int rt = (c + 1 < n) ? grid[r][c + 1] : 0;
                    grid[r][c] = d + rt;
                }
            }
        }

        return grid[0][0];
    }
}