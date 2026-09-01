class Solution {
    private int[] pre;
    private int[][] memo;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        pre = new int[n + 1];
        memo = new int[n][n];

        for (int[] row : memo) Arrays.fill(row, -1);

        for (int i = 1; i < n + 1; i++) pre[i] = pre[i - 1] + piles[i - 1];
        return dp(0, 1, n);
    }

    private int dp(int i, int m, int n) {
        if (n - i <= 2 * m)
            return pre[n] - pre[i];

        if (memo[i][m] != -1)
            return memo[i][m];

        int res = -1;

        for (int x = 1; x <= 2 * m; x++) {
            res = Math.max(pre[n] - pre[i] - dp(i + x, Math.max(m, x), n), res);
        }

        memo[i][m] = res;
        return res;
    }
}