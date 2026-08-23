class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length(), m = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = m; i >= 0; i--) {
            boolean dp1 = dp[n];
            dp[n] = (i == m);
            for (int j = n - 1; j >= 0; j--) {
                boolean match = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                boolean res = false;
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    res = dp[j + 2];
                    if (match)
                        res |= dp[j];
                } else if (match)
                    res = dp1;
                dp1 = dp[j];
                dp[j] = res;
            }
        }
        return dp[0];
    }
}
