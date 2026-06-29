class Solution:
    def isHappy(self, n: int) -> bool:
        seen = []

        while n:
            res = 0
            for d in str(n):
                res += int(d) ** 2
            if res == 1: return True
            elif res in seen: return False
            seen.append(res)
            n = res
        return False