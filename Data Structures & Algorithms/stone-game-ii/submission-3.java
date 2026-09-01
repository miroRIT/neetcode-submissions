class Solution {
    private int[] suf_sum;
    private int[][] memo;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suf_sum = new int[n + 1];
        memo = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) suf_sum[i] = suf_sum[i + 1] + piles[i];

        return dp(0, 1, n);
    }

    private int dp(int i, int m, int n) {
        if ((i + 2 * m) >= n)
            return suf_sum[i];

        if (memo[i][m] != 0)
            return memo[i][m];
        int bst = 0;

        for (int x = 1; x < 2 * m + 1; x++) {
            int opp = dp(i + x, Math.max(m, x), n);
            int cur = suf_sum[i] - opp;
            bst = Math.max(cur, bst);
        }

        memo[i][m] = bst;
        return bst;
    }
}