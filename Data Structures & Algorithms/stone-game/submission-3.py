class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)
        dp = [0] * n

        for l in range(n - 1, -1, -1):
            for r in range(l, n):
                if (r - l) % 2 == 0:
                    lt = piles[l]
                    rt = piles[r]
                else:
                    lt = rt = 0

                if l == r:
                    dp[r] = rt
                else:
                    dp[r] = max(dp[r] + lt, dp[r - 1] + rt)

        tot = 0
        for pile in piles:
            tot += pile
        a = dp[n - 1]

        return a > (tot - a)
