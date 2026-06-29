class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums, target, 0, len(nums) - 1)
        
    def binarySearch(self, nums: List[int], target: int, left: int, right: int) -> int:
        if left > right: return -1
        mid = left + (right - left) // 2
        if nums[mid] == target: return mid
        if target > nums[mid]: return self.binarySearch(nums, target, mid + 1, right)
        return self.binarySearch(nums, target, left, mid - 1)