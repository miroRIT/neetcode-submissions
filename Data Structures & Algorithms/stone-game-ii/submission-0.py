class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        suf_sum = [0] * n
        suf_sum[-1] = piles[-1]

        for i in range(n - 2, -1, -1):
            suf_sum[i] = suf_sum[i + 1] + piles[i]

        dp = [[0] * (n + 1) for _ in range(n + 1)]

        for i in range(n - 1, -1, -1):
            for m in range(1, n + 1):
                for x in range(1, 2 * m + 1):
                    if i + x > n:
                        break
                    dp[i][m] = max(dp[i][m], suf_sum[i] - dp[i + x][max(m, x)])

        return dp[0][1]
