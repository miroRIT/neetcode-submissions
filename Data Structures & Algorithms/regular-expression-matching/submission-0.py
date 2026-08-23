class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n, m = len(p), len(s)
        dp = [False] * (n + 1)
        dp[n] = True

        for i in range(m, -1, -1):
            dp1 = dp[n]
            dp[n] = i == m
            for j in range(n - 1, -1, -1):
                match = i < m and (s[i] == p[j] or p[j] == ".")
                res = False
                if (j + 1) < n and p[j + 1] == '*':
                    res = dp[j + 2]
                    if match:
                        res |= dp[j]
                elif match:
                    res = dp1
                dp[j], dp1 = res, dp[j]
        
        return dp[0]