class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                int m = w.length();
                if ((i + m) <= n && s.substring(i, i + m).equals(w))
                    dp[i] = dp[i + m];
                if (dp[i])
                    break;
            }
        }

        return dp[0];
    }
}
