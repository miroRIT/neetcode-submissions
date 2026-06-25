class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        return True if len(nums) - len(list(set(nums))) > 0 else False
        