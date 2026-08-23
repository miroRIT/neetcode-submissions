class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] new_nums = new int[n + 2];
        new_nums[0] = new_nums[n + 1] = 1;
        for (int i = 0; i < n; i++) new_nums[i + 1] = nums[i];

        int[][] dp = new int[n + 2][n + 2];

        for (int l = n; l > 0; l--) {
            for (int r = l; r < n + 1; r++) {
                for (int i = l; i <= r; i++) {
                    int coins = new_nums[l - 1] * new_nums[i] * new_nums[r + 1];
                    coins += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(coins, dp[l][r]);
                }
            }
        }

        return dp[1][n];
    }
}
