class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                boolean even = (r - l) % 2 == 0;
                int lt = even ? piles[l] : 0;
                int rt = even ? piles[r] : 0;

                if (l == r)
                    dp[r] = lt;
                else
                    dp[r] = Math.max(dp[r] + lt, dp[r - 1] + rt);
            }
        }

        int tot = 0;
        for (int pile : piles) tot += pile;

        int a = dp[n - 1];
        return a > (tot - a);
    }
}