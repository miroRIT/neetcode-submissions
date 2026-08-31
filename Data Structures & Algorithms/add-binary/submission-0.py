class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = []
        car = 0

        i, j = len(a) - 1, len(b) - 1

        while i >= 0 or j >= 0 or car:
            digA = int(a[i]) if i >= 0 else 0
            digB = int(b[j]) if j >= 0 else 0

            tot = digA + digB + car
            res.append(tot % 2)
            car = tot // 2

            i -= 1
            j -= 1
        
        res.reverse()
        return ''.join(map(str, res))