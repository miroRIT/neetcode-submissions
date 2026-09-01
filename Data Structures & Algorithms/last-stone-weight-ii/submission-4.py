from functools import cache


class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        tot = sum(stones)
        n = len(stones)
        bst = 0

        @cache
        def f(idx: int, tar: int) -> bool:
            if not tar:
                return True
            if idx >= n or tar < 0:
                return False
            return f(idx + 1, tar - stones[idx]) or f(idx + 1, tar)

        for i in range(tot // 2, -1, -1):
            if f(0, i):
                bst = i
                break

        return tot - 2 * bst
