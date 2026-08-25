class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        l, r = max(nums), sum(nums)

        def canSplit(largest):
            subArr = 1
            curSum = 0
            for num in nums:
                curSum += num
                if curSum > largest:
                    subArr += 1
                    if subArr > k:
                        return False
                    curSum = num

            return True

        res = r
        while l <= r:
            m = l + (r - l) // 2
            if canSplit(m):
                res = m
                r = m - 1
            else:
                l = m + 1

        return res
