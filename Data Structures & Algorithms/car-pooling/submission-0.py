class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        l, r = float("inf"), float("-inf")

        for _, s, e in trips:
            l = min(l, s)
            r = max(r, e)

        n = r - l + 1
        passChange = [0] * n

        for pas, s, e in trips:
            passChange[s - l] += pas
            passChange[e - l] -= pas

        curPas = 0
        for change in passChange:
            curPas += change
            if curPas > capacity:
                return False

        return True
