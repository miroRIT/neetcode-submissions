class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        n = len(nums)
        if not n:
            return False
        nums.sort()
        prev_elem = nums[0]
        for i in range(1, n):
            if nums[i] == prev_elem:
                return True
            prev_elem = nums[i]
        return False
        