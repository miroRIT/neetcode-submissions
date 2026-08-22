class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }
        int m = word1.length(), n = word2.length();

        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) dp[i] = n - i;
        for (int i = m - 1; i >= 0; i--) {
            int nextDp = dp[n];
            dp[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int tmp = dp[j];
                if (word1.charAt(i) == word2.charAt(j))
                    dp[j] = nextDp;
                else
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j + 1], nextDp));
                nextDp = tmp;
            }
        }
        return dp[0];
    }
}
