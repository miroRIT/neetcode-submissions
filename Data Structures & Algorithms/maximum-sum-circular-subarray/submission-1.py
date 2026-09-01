class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        gmax = gmin = nums[0]
        cmin = cmax = tot = 0

        for num in nums:
            cmin = min(cmin + num, num)
            gmin = min(gmin, cmin)
            cmax = max(cmax + num, num)
            gmax = max(gmax, cmax)
            tot += num

        return max(gmax, tot - gmin) if gmax > 0 else gmax
