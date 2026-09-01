from functools import lru_cache

class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        suf_sum = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            suf_sum[i] = suf_sum[i + 1] + piles[i]

        @lru_cache(None)
        def dp(i: int, m: int) -> int:
            if i + 2 * m >= n:
                return suf_sum[i]
            
            bst = 0
            for x in range(1, 2 * m + 1):
                opp = dp(i + x, max(m, x))
                cur = suf_sum[i] - opp
                bst = max(bst, cur)
            return bst

        return dp(0, 1)
