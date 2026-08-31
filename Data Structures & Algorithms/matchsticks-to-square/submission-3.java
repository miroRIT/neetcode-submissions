class Solution {
    private int[] dp;
    private int len, n;

    public boolean makesquare(int[] matchsticks) {
        int tl = 0;

        for (int match : matchsticks) {
            tl += match;
            len = Math.max(match, len);
        }

        if (tl % 4 != 0 || len > tl / 4)
            return false;

        len = tl / 4;
        n = matchsticks.length;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        dp = new int[1 << n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        return dfs((1 << n) - 1, matchsticks) == 0;
    }

    private int dfs(int mask, int[] matchsticks) {
        if (mask == 0)
            return 0;

        if (dp[mask] != Integer.MIN_VALUE)
            return dp[mask];

        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                int res = dfs(mask ^ (1 << i), matchsticks);
                if (res >= 0 && res + matchsticks[i] <= len) {
                    dp[mask] = (res + matchsticks[i]) % len;
                    return dp[mask];
                }
                if (mask == (1 << n) - 1) {
                    dp[mask] = -1;
                    return -1;
                }
            }
        }

        dp[mask] = -1;
        return -1;
    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
    }
}