class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0
        nums.sort()
        n = len(nums)

        for i in range(n):
            streak, curr = 0, nums[i]
            while curr in nums:
                streak += 1
                curr += 1
            res = max(res, streak)
            i += streak
        return res
        