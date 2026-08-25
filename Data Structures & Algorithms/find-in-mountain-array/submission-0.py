class Solution:
    def findInMountainArray(self, target: int, mountainArr: "MountainArray") -> int:
        cache = {}
        len = mountainArr.length()

        def get(i):
            if i not in cache:
                cache[i] = mountainArr.get(i)
            return cache[i]

        l, r = 1, len - 2

        while l <= r:
            m = (l + r) >> 1
            left, mid, right = get(m - 1), get(m), get(m + 1)
            if left < mid < right:
                l = m + 1
            elif left > mid > right:
                r = m - 1
            else:
                break

        peak = m

        def binary(l, r, asc):

            while l <= r:
                m = (l + r) >> 1
                val = get(m)
                if val == target:
                    return m
                if asc == (val < target):
                    l = m + 1
                else:
                    r = m - 1

            return -1

        res = binary(0, peak, True)

        if res != -1:
            return res

        return binary(peak, len - 1, False)
