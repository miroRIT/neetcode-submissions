class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] dp = new int[cols + 1];
        for (int c = 0; c <= cols; c++) dp[c] = Integer.MAX_VALUE;

        dp[cols - 1] = 0;

        for (int r = rows - 1; r >= 0; r--)
            for (int c = cols - 1; c >= 0; c--) dp[c] = grid[r][c] + Math.min(dp[c], dp[c + 1]);

        return dp[0];
    }
}