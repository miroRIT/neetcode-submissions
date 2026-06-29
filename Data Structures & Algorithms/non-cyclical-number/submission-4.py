class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        while n != 1 and n not in seen:
            seen.add(n)
            res = 0
            for d in str(n):
                res += int(d) ** 2
            n = res
        return n == 1