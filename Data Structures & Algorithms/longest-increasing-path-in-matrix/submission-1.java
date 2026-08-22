class Solution {
    private int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        int lip = 0;
        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) dp[i][j] = -1;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                lip = Math.max(lip, dfs(matrix, r, c, Integer.MIN_VALUE));

        return lip;
    }

    private int dfs(int[][] matrix, int r, int c, int preVal) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || matrix[r][c] <= preVal)
            return 0;

        if (dp[r][c] != -1)
            return dp[r][c];

        int res = 1;
        for (int[] d : directions)
            res = Math.max(res, 1 + dfs(matrix, r + d[0], c + d[1], matrix[r][c]));

        return dp[r][c] = res;
    }
}
