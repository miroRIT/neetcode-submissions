class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        while n != 1 and n not in seen:
            seen.add(n)
            res = 0
            while n > 0:
                digit = n % 10
                res += digit * digit
                n //= 10
            n = res
        return n == 1