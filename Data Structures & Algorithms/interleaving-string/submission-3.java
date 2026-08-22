class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        if (s1.length() > s2.length()){
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = m; i >= 0; i--){
            boolean nextDp = (i == m ? true : false);
            for (int j = n; j >= 0; j--){
                boolean res = (j < n ? false : nextDp);
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[j])
                    res = true;
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && nextDp)
                    res = true;
                
                dp[j] = res;
                nextDp = dp[j];
            }
        }
        return dp[0];
    }
}
